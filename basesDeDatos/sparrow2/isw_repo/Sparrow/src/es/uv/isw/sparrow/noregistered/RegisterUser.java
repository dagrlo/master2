package es.uv.isw.sparrow.noregistered;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uv.isw.sparrow.bean.User;
import es.uv.isw.sparrow.dao.MySQLUserDAO;

@WebServlet("/Register")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterUser() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String pwd = request.getParameter("password");
		String mail = request.getParameter("eMail");
		String fName = request.getParameter("firstName");
		String surname = request.getParameter("surname");
		String gender = request.getParameter("gender");
		String lang = request.getParameter("language");
		// Check data syntax
		boolean passedTest = true;
		if (userName.length() < 4)
			passedTest = false;
		if (pwd.length() < 4)
			passedTest = false;
		if (!validateEmail(mail))
			passedTest = false;
		if (fName.length() < 2)
			passedTest = false;
		else if (!validateLetters(fName))
			passedTest = false;
		if (surname.length() < 2)
			passedTest = false;
		else if (!validateLetters(surname))
			passedTest = false;
		if (!gender.equals("V") && !gender.equals("M"))
			passedTest = false;
		if (!lang.equals("es") && !lang.equals("en") && !lang.equals("de"))
			passedTest = false;

		if (passedTest) {
			MySQLUserDAO u = new MySQLUserDAO();
			try {
				ArrayList<User> array = u.getAllUsers();
				System.out.println("User DB has " + array.size() + " users");
				for (User item : array) {
					if (userName.equalsIgnoreCase(item.getUsername())) {
						System.out.println("Server: Username " + userName
								+ " is already registered in the DB");
						passedTest = false;
					}
				}
				if (passedTest) {
					System.out.println("Server: Registering user: " + userName
							+ " " + pwd + " " + mail + " " + fName + " "
							+ surname + " " + gender + " " + lang);
					registerUser(userName, pwd, mail, fName, surname, gender,
							lang);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out
						.println("Server: Exception when trying to retrieve all users");
			}
		}
		// Forward back to the register form if any problem is found
		if (passedTest)
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		// Send it to Login otherwise
		else
			request.getRequestDispatcher("RegisterForm.jsp").forward(request,
					response);
	}

	private boolean validateEmail(String mail) {
		String re = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		Boolean result = mail.matches(re);
		if (result == false)
			System.out.println("Server reports " + mail
					+ " doesn't seem a valid mail address");
		return result;
	}

	private boolean validateLetters(String str) {
		String re = "^[\\p{L} .'-]+$";
		Boolean result = str.matches(re);
		if (result == false)
			System.out.println("Server reports " + str
					+ " seems to have more than letters");
		return result;
	}

	private void registerUser(String userName, String pwd, String mail,
			String fName, String surname, String gender, String lang) {
		MySQLUserDAO dao = new MySQLUserDAO();
		User u = new User();
		u.setUsername(userName);
		u.setPassword(pwd);
		u.seteMail(mail);
		u.setNombre(fName);
		u.setApellidos(surname);
		u.setSexo(gender);
		u.setIdioma(lang);
		try {
			dao.insert(u);
		} catch (SQLException e) {
			System.out
					.println("Server: Exception when trying to insert the user in the DB");
			e.printStackTrace();
		}

		try {
			ArrayList<User> array = dao.getAllUsers();
			System.out.println("User DB has " + array.size() + " users");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
