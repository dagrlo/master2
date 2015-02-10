/***********************************************************************
 *
 * $CVSHeader$
 *
 * This file is part of WebScarab, an Open Web Application Security
 * Project utility. For details, please see http://www.owasp.org/
 *
 * Copyright (c) 2002 - 2004 Rogan Dawes
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 * Getting Source
 * ==============
 *
 * Source for this application is maintained at Sourceforge.net, a
 * repository for free software projects.
 * 
 * For details, please see http://www.sourceforge.net/projects/owasp
 *
 */

/*
 * RevealHiddenPanel.java
 *
 * Created on July 25, 2003, 10:58 PM
 */

package org.owasp.webscarab.plugin.proxy.swing;

import org.owasp.webscarab.plugin.proxy.RevealHidden;
import org.owasp.webscarab.plugin.proxy.BrowserCache;
import org.owasp.webscarab.plugin.proxy.CookieTracker;

/**
 *
 * @author  rdawes
 */
public class MiscPanel extends javax.swing.JPanel implements ProxyPluginUI {
    
    private RevealHidden _revealHidden;
    private BrowserCache _browsercache;
    private CookieTracker _cookieTracker;
    
    /** Creates new form RevealHiddenPanel */
    public MiscPanel(RevealHidden rh, BrowserCache bc, CookieTracker ct) {
        _revealHidden = rh;
        _browsercache = bc;
        _cookieTracker = ct;
        
        initComponents();
        configure();
    }

    public javax.swing.JPanel getPanel() {
        return this;
    }    
    
    public String getPluginName() {
        return new String("Miscellaneous");
    }    
    
    private void configure() {
        interceptHiddenFieldCheckBox.setSelected(_revealHidden.getEnabled());
        browserCacheCheckBox.setSelected(_browsercache.getEnabled());
        injectRequestCookiesCheckBox.setSelected(_cookieTracker.getInjectRequests());
        readResponseCookiesCheckBox.setSelected(_cookieTracker.getReadResponses());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        interceptHiddenFieldCheckBox = new javax.swing.JCheckBox();
        browserCacheCheckBox = new javax.swing.JCheckBox();
        spacerLabel = new javax.swing.JLabel();
        injectRequestCookiesCheckBox = new javax.swing.JCheckBox();
        readResponseCookiesCheckBox = new javax.swing.JCheckBox();

        setLayout(new java.awt.GridBagLayout());

        interceptHiddenFieldCheckBox.setText("Reveal hidden fields in HTML pages : ");
        interceptHiddenFieldCheckBox.setToolTipText("Select this to change all hidden form fields to text fields. Looks at pages of type HTML and javascript.");
        interceptHiddenFieldCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        interceptHiddenFieldCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interceptHiddenFieldCheckBoxActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(interceptHiddenFieldCheckBox, gridBagConstraints);

        browserCacheCheckBox.setText("Prevent browser from caching content : ");
        browserCacheCheckBox.setToolTipText("");
        browserCacheCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        browserCacheCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browserCacheCheckBoxActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(browserCacheCheckBox, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(spacerLabel, gridBagConstraints);

        injectRequestCookiesCheckBox.setText("Inject known cookies into requests");
        injectRequestCookiesCheckBox.setToolTipText("");
        injectRequestCookiesCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        injectRequestCookiesCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                injectRequestCookiesCheckBoxActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(injectRequestCookiesCheckBox, gridBagConstraints);

        readResponseCookiesCheckBox.setText("Get cookies from responses");
        readResponseCookiesCheckBox.setToolTipText("");
        readResponseCookiesCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        readResponseCookiesCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readResponseCookiesCheckBoxActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(readResponseCookiesCheckBox, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void readResponseCookiesCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readResponseCookiesCheckBoxActionPerformed
        _cookieTracker.setReadResponses(readResponseCookiesCheckBox.isSelected());
    }//GEN-LAST:event_readResponseCookiesCheckBoxActionPerformed

    private void injectRequestCookiesCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_injectRequestCookiesCheckBoxActionPerformed
        _cookieTracker.setInjectRequests(injectRequestCookiesCheckBox.isSelected());
    }//GEN-LAST:event_injectRequestCookiesCheckBoxActionPerformed

    private void browserCacheCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browserCacheCheckBoxActionPerformed
        _browsercache.setEnabled(browserCacheCheckBox.isSelected());
    }//GEN-LAST:event_browserCacheCheckBoxActionPerformed

    private void interceptHiddenFieldCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interceptHiddenFieldCheckBoxActionPerformed
        _revealHidden.setEnabled(interceptHiddenFieldCheckBox.isSelected());
    }//GEN-LAST:event_interceptHiddenFieldCheckBoxActionPerformed

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        browserCacheCheckBox.setEnabled(enabled);
        injectRequestCookiesCheckBox.setEnabled(enabled);
        interceptHiddenFieldCheckBox.setEnabled(enabled);
        readResponseCookiesCheckBox.setEnabled(enabled);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox browserCacheCheckBox;
    private javax.swing.JCheckBox injectRequestCookiesCheckBox;
    private javax.swing.JCheckBox interceptHiddenFieldCheckBox;
    private javax.swing.JCheckBox readResponseCookiesCheckBox;
    private javax.swing.JLabel spacerLabel;
    // End of variables declaration//GEN-END:variables
    
}
