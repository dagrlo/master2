<?php

//1.conectar base de datos
$conexion=mysqli_connect("localhost", "udb","pudb", "Buses");

if(mysqli_connect_errno())
{
echo 'Error, I cannot connect the DataBase..';
exit;
}

print "<p> BUS REVIEW </p>";

$idRevision=$_REQUEST['idRevision'];
$nomRevisor=$_REQUEST['nombreRevisor'];
$id畂敳㵳␀开刀䔀儀唀䔀匀吀嬀✀椀搀开Buses开爀✀崀㬀ഀ਀␀昀攀挀栀愀㴀␀开刀䔀儀唀䔀匀吀嬀✀昀攀挀栀愀开爀攀瘀椀猀椀漀渀✀崀㬀ഀ਀⼀⼀瘀愀爀开搀甀洀瀀⠀␀椀搀刀攀瘀椀猀椀漀渀⤀㬀搀椀攀㬀ഀ਀椀昀⠀℀␀椀搀刀攀瘀椀猀椀漀渀⤀ഀ਀笀ഀ਀瀀爀椀渀琀 ∀㰀瀀㸀 夀漀甀 洀甀猀琀 瀀爀漀瘀椀搀攀 琀栀攀 爀攀瘀椀攀眀 椀搀攀渀琀椀昀椀攀爀㰀⼀瀀㸀∀㬀ऀഀ਀紀ഀ਀攀氀猀攀 椀昀⠀℀␀渀漀洀刀攀瘀椀猀漀爀⤀ऀഀ਀笀ഀ਀瀀爀椀渀琀 ∀㰀瀀㸀 夀漀甀 洀甀猀琀 瀀爀漀瘀椀搀攀 琀栀攀 爀攀瘀椀攀眀攀爀 渀愀洀攀㰀⼀瀀㸀∀㬀ऀഀ਀紀ഀ਀攀氀猀攀 椀昀⠀℀␀椀搀Buses⤀ഀ਀笀ഀ਀瀀爀椀渀琀 ∀㰀瀀㸀 夀漀甀 洀甀猀琀 瀀爀漀瘀椀搀攀 琀栀攀 戀甀猀 椀搀攀渀琀椀昀椀攀爀 㰀⼀瀀㸀∀㬀ഀ਀紀ഀ਀攀氀猀攀 椀昀⠀℀␀昀攀挀栀愀⤀ഀ਀笀ഀ਀瀀爀椀渀琀 ∀㰀瀀㸀 夀漀甀 洀甀猀琀 瀀爀漀瘀椀搀攀 琀栀攀 爀攀瘀椀攀眀 搀愀琀攀㰀⼀瀀㸀∀㬀ഀ਀紀ഀ਀ഀ਀ഀ਀攀氀猀攀ഀ਀笀ഀ਀⼀⼀挀漀洀瀀爀漀戀愀洀漀猀 焀甀攀 氀愀 昀攀挀栀愀 渀漀 攀猀琀 攀渀 氀愀 琀愀戀氀愀 刀攀瘀椀猀愀爀 瀀愀爀愀 攀猀愀 Buses 攀渀 挀漀渀挀爀攀琀漀ഀ਀␀挀漀渀猀甀氀琀愀开昀攀挀栀愀㴀∀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 刀攀瘀椀猀愀爀 眀栀攀爀攀 昀攀挀栀愀㴀✀␀昀攀挀栀愀✀ 愀渀搀 椀搀Buses㴀✀␀椀搀Buses✀∀㬀ഀ਀␀爀攀猀开挀漀渀猀甀氀琀愀开昀攀挀栀愀㴀洀礀猀焀氀椀开焀甀攀爀礀⠀␀挀漀渀攀砀椀漀渀Ⰰ ␀挀漀渀猀甀氀琀愀开昀攀挀栀愀⤀㬀ഀ਀␀渀甀洀开爀攀猀开挀漀渀猀甀氀琀愀开昀攀挀栀愀㴀洀礀猀焀氀椀开渀甀洀开爀漀眀猀⠀␀爀攀猀开挀漀渀猀甀氀琀愀开昀攀挀栀愀⤀㬀ഀ਀ഀ਀ഀ਀⼀⼀挀漀洀瀀爀漀戀愀洀漀猀 焀甀攀 氀愀 Buses 渀漀 攀猀琀 攀渀 氀愀 琀愀戀氀愀 刀攀瘀椀猀愀爀ഀ਀⼀⼀␀挀漀渀猀甀氀琀愀开Buses㴀∀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 刀攀瘀椀猀愀爀 眀栀攀爀攀 椀搀Buses㴀✀␀椀搀Buses✀∀㬀ഀ਀⼀⼀␀爀攀猀开挀漀渀猀甀氀琀愀开Buses㴀洀礀猀焀氀椀开焀甀攀爀礀⠀␀挀漀渀攀砀椀漀渀Ⰰ ␀挀漀渀猀甀氀琀愀开Buses⤀㬀ഀ਀⼀⼀␀渀甀洀开爀攀猀开挀漀渀猀甀氀琀愀开Buses㴀洀礀猀焀氀椀开渀甀洀开爀漀眀猀⠀␀爀攀猀开挀漀渀猀甀氀琀愀开Buses⤀㬀ഀ਀ഀ਀⼀⼀挀漀洀瀀爀漀戀愀洀漀猀 焀甀攀 氀愀 Buses 攀砀椀猀琀攀 攀渀 攀氀 猀椀猀琀攀洀愀ഀ਀␀挀漀渀猀甀氀琀愀开Buses㴀∀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 Buses 眀栀攀爀攀 椀搀Buses㴀✀␀椀搀Buses✀∀㬀ഀ਀␀爀攀猀甀氀琀开挀漀渀猀甀氀琀愀开Buses㴀洀礀猀焀氀椀开焀甀攀爀礀⠀␀挀漀渀攀砀椀漀渀Ⰰ ␀挀漀渀猀甀氀琀愀开Buses⤀㬀ഀ਀␀渀甀洀开爀攀猀甀氀琀开挀漀渀猀甀氀琀愀开Buses㴀洀礀猀焀氀椀开渀甀洀开爀漀眀猀⠀␀爀攀猀甀氀琀开挀漀渀猀甀氀琀愀开Buses⤀㬀ഀ਀ഀ਀⼀⼀戀甀猀挀愀爀 椀搀刀攀瘀椀猀椀漀渀 攀渀琀爀攀 氀愀猀 爀攀瘀椀猀椀漀渀攀猀 攀砀椀猀琀攀渀琀攀猀ഀ਀␀挀漀渀猀甀氀琀愀开爀攀瘀椀猀椀漀渀㴀∀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 刀攀瘀椀猀愀爀 眀栀攀爀攀 椀搀刀攀瘀椀猀椀漀渀㴀✀␀椀搀刀攀瘀椀猀椀漀渀✀∀㬀ഀ਀␀爀攀猀甀氀琀开挀漀渀猀甀氀琀愀开爀攀瘀椀猀椀漀渀㴀洀礀猀焀氀椀开焀甀攀爀礀⠀␀挀漀渀攀砀椀漀渀Ⰰ␀挀漀渀猀甀氀琀愀开爀攀瘀椀猀椀漀渀⤀㬀ഀ਀␀渀甀洀开爀攀猀甀氀琀开挀漀渀猀甀氀琀愀开爀攀瘀椀猀椀漀渀㴀洀礀猀焀氀椀开渀甀洀开爀漀眀猀⠀␀爀攀猀甀氀琀开挀漀渀猀甀氀琀愀开爀攀瘀椀猀椀漀渀⤀㬀ഀ਀ഀ਀椀昀⠀␀渀甀洀开爀攀猀甀氀琀开挀漀渀猀甀氀琀愀开爀攀瘀椀猀椀漀渀⤀ഀ਀笀ഀ਀瀀爀椀渀琀 ∀㰀瀀㸀 䐀甀瀀氀椀挀愀琀攀搀 爀攀瘀椀攀眀 椀搀攀渀琀椀昀椀攀爀Ⰰ 瀀氀攀愀猀攀 瀀爀漀瘀椀搀攀 愀 渀攀眀 漀渀攀⸀ 㰀⼀瀀㸀∀㬀ഀ਀紀ഀ਀攀氀猀攀ഀ਀笀ഀ਀ऀ椀昀⠀℀␀渀甀洀开爀攀猀甀氀琀开挀漀渀猀甀氀琀愀开Buses⤀ऀഀ਀ऀ笀ऀഀ਀ऀऀ瀀爀椀渀琀 ∀㰀瀀㸀 䈀甀猀 搀漀攀猀 渀漀琀 攀砀椀猀琀 椀渀 琀栀攀 猀礀猀琀攀洀⸀ 吀漀 挀爀攀愀琀攀 椀琀Ⰰ 瀀氀攀愀猀攀 最漀 琀漀 䌀爀攀愀琀攀 戀甀猀 尀渀 㰀⼀瀀㸀∀㬀ഀ਀ऀ紀ഀ਀ऀ攀氀猀攀 椀昀⠀␀渀甀洀开爀攀猀甀氀琀开挀漀渀猀甀氀琀愀开Buses⤀ഀ਀ऀ笀ऀഀ਀ഀ਀ऀऀ椀昀⠀␀渀甀洀开爀攀猀开挀漀渀猀甀氀琀愀开昀攀挀栀愀⤀ഀ਀ऀऀ笀ഀ਀ऀऀऀ瀀爀椀渀琀 ∀㰀瀀㸀 䈀甀猀 愀氀爀攀愀搀礀 爀攀瘀椀攀眀攀搀 椀渀 搀愀琀攀㨀 ∀⸀␀昀攀挀栀愀⸀∀㰀⼀瀀㸀∀㬀ഀ਀ऀऀ紀ഀ਀ऀऀ攀氀猀攀 ഀ਀ऀऀ笀ഀ਀ऀऀऀ␀氀椀猀琀愀搀漀㴀∀匀䔀䰀䔀䌀吀 椀搀倀愀猀愀樀攀爀漀 䘀刀伀䴀 倀愀猀愀樀攀爀漀 眀栀攀爀攀 椀搀一愀瘀攀㴀✀␀椀搀Buses✀∀㬀ഀ਀ऀऀऀ␀挀漀渀猀甀氀琀愀开氀椀猀琀愀搀漀㴀洀礀猀焀氀椀开焀甀攀爀礀⠀␀挀漀渀攀砀椀漀渀Ⰰ ␀氀椀猀琀愀搀漀⤀㬀ഀ਀ऀऀऀ␀渀甀洀开挀漀渀猀甀氀琀愀开氀椀猀琀愀搀漀㴀洀礀猀焀氀椀开渀甀洀开爀漀眀猀⠀␀挀漀渀猀甀氀琀愀开氀椀猀琀愀搀漀⤀㬀ഀ਀ऀऀऀ椀昀⠀␀渀甀洀开挀漀渀猀甀氀琀愀开氀椀猀琀愀搀漀 㸀 　⤀ഀ਀ऀऀऀ笀ഀ਀ऀऀऀ瀀爀椀渀琀 ∀㰀瀀㸀 吀栀攀 戀甀猀 爀攀瘀椀攀眀 挀漀甀氀搀 戀攀 搀漀渀攀 猀甀挀挀攀猀猀昀甀氀氀礀 椀渀 琀栀攀 猀瀀攀挀椀昀椀攀搀 搀愀琀攀 㰀⼀瀀㸀∀㬀ഀ਀ऀऀऀ␀瀀愀猀愀樀攀爀漀猀开椀搀㬀ഀ਀ऀऀऀ⼀⼀昀漀爀 ⠀␀椀㴀　㬀 ␀椀㰀␀渀甀洀开挀漀渀猀甀氀琀愀开氀椀猀琀愀搀漀㬀 ␀椀⬀⬀⤀ഀ਀ऀऀऀ眀栀椀氀攀⠀␀昀椀氀愀㴀洀礀猀焀氀椀开昀攀琀挀栀开愀爀爀愀礀⠀␀挀漀渀猀甀氀琀愀开氀椀猀琀愀搀漀⤀⤀ഀ਀ऀऀऀ笀ഀ਀ऀऀऀऀऀऀ⼀⼀␀昀椀氀愀㴀洀礀猀焀氀椀开昀攀琀挀栀开愀猀猀漀挀⠀␀挀漀渀猀甀氀琀愀开氀椀猀琀愀搀漀⤀㬀ഀ਀ऀऀऀऀऀऀ⼀⼀␀昀椀氀愀㴀洀礀猀焀氀椀开昀攀琀挀栀开愀爀爀愀礀⠀␀挀漀渀猀甀氀琀愀开氀椀猀琀愀搀漀⤀㬀ഀ਀ऀऀऀऀऀऀ⼀⼀␀昀椀氀愀开愀爀爀嬀␀椀崀㴀␀昀椀氀愀嬀椀搀倀愀猀愀樀攀爀漀崀㬀ഀ਀ऀऀऀऀऀऀ瀀爀椀渀琀 ∀㰀瀀㸀 倀愀猀愀樀攀爀漀㨀∀⸀␀昀椀氀愀嬀　崀⸀∀ 㰀⼀瀀㸀∀㬀ഀ਀ऀऀऀऀऀऀ␀瀀愀猀愀樀攀爀漀猀开椀搀 ⸀㴀 ␀昀椀氀愀嬀✀椀搀倀愀猀愀樀攀爀漀✀崀 ⸀ ∀Ⰰ ∀㬀ഀ਀ऀऀऀऀऀऀഀ਀ऀऀऀ紀⼀⼀眀栀椀氀攀ഀ਀ऀऀऀऀऀ␀椀渀猀攀爀琀愀爀㴀∀䤀一匀䔀刀吀 䤀一吀伀 刀攀瘀椀猀愀爀 嘀䄀䰀唀䔀匀 ⠀✀␀椀搀刀攀瘀椀猀椀漀渀✀Ⰰ ✀␀渀漀洀刀攀瘀椀猀漀爀✀Ⰰ ✀␀椀搀Buses✀Ⰰ ✀␀昀攀挀栀愀✀Ⰰ ✀␀瀀愀猀愀樀攀爀漀猀开椀搀✀⤀∀㬀ഀ਀ऀऀऀऀऀ␀爀攀猀甀氀琀开椀渀猀攀爀琀愀爀㴀洀礀猀焀氀椀开焀甀攀爀礀⠀␀挀漀渀攀砀椀漀渀Ⰰ ␀椀渀猀攀爀琀愀爀⤀㬀ഀ਀ऀऀऀऀऀ␀渀甀洀开爀攀猀甀氀琀开椀渀猀攀爀琀愀爀㴀洀礀猀焀氀椀开愀昀昀攀挀琀攀搀开爀漀眀猀⠀␀挀漀渀攀砀椀漀渀⤀㬀ഀ਀ऀऀऀഀ਀ऀऀऀഀ਀ऀऀऀ椀昀⠀␀渀甀洀开爀攀猀甀氀琀开椀渀猀攀爀琀愀爀⤀ഀ਀ऀऀऀ笀ഀ਀ऀऀऀऀ瀀爀椀渀琀 ∀㰀瀀㸀 吀栀攀 爀攀瘀椀攀眀 栀愀猀 戀攀攀渀 猀琀漀爀攀搀 椀渀 琀栀攀 猀礀猀琀攀洀 猀甀挀挀攀猀猀昀甀氀氀礀㰀⼀瀀㸀∀㬀ഀ਀ऀऀऀ紀⼀⼀椀昀ഀ਀ऀऀऀ紀⼀⼀椀昀ഀ਀ऀऀऀ攀氀猀攀ഀ਀ऀऀऀ笀ഀ਀ऀऀऀऀ瀀爀椀渀琀 ∀㰀瀀㸀 吀栀攀爀攀 椀猀 渀漀 瀀愀猀猀攀渀最攀爀 椀渀 琀栀攀 戀甀猀 ∀⸀␀椀搀Buses⸀∀ 㰀⼀瀀㸀∀㬀ഀ਀ऀऀऀ紀ഀ਀ऀऀ紀⼀⼀攀氀猀攀ऀऀഀ਀ऀ紀⼀⼀攀氀猀攀椀昀ഀ਀ऀഀ਀紀ഀ਀紀ഀ਀ഀ਀瀀爀椀渀琀 ∀㰀瀀㸀 䰀䤀匀吀 伀䘀 刀䤀嘀䤀䔀圀匀 㰀⼀瀀㸀∀㬀ഀ਀␀挀漀渀猀甀氀琀愀开爀攀瘀椀猀椀漀渀攀猀㴀∀匀䔀䰀䔀䌀吀 ⨀ 䘀刀伀䴀 刀攀瘀椀猀愀爀∀㬀ഀ਀␀爀攀猀甀氀琀开挀漀渀猀甀氀琀愀开爀攀瘀椀猀椀漀渀攀猀㴀洀礀猀焀氀椀开焀甀攀爀礀⠀␀挀漀渀攀砀椀漀渀Ⰰ␀挀漀渀猀甀氀琀愀开爀攀瘀椀猀椀漀渀攀猀⤀㬀ഀ਀␀渀甀洀开爀攀猀甀氀琀开挀漀渀猀甀氀琀愀开爀攀瘀椀猀椀漀渀攀猀㴀洀礀猀焀氀椀开渀甀洀开爀漀眀猀⠀␀爀攀猀甀氀琀开挀漀渀猀甀氀琀愀开爀攀瘀椀猀椀漀渀攀猀⤀㬀ഀ਀昀漀爀⠀␀椀㴀　㬀 ␀椀㰀␀渀甀洀开爀攀猀甀氀琀开挀漀渀猀甀氀琀愀开爀攀瘀椀猀椀漀渀攀猀㬀 ␀椀⬀⬀⤀ഀ਀笀ഀ਀␀昀椀氀愀㴀洀礀猀焀氀椀开昀攀琀挀栀开爀漀眀⠀␀爀攀猀甀氀琀开挀漀渀猀甀氀琀愀开爀攀瘀椀猀椀漀渀攀猀⤀㬀ഀ਀瀀爀椀渀琀 ∀㰀瀀㸀 刀攀瘀椀攀眀 椀搀攀渀琀椀昀椀攀爀㨀 ∀⸀␀昀椀氀愀嬀　崀⸀ ∀⸀ 刀攀瘀椀攀眀攀爀 渀愀洀攀㨀 ∀ ⸀␀昀椀氀愀嬀㄀崀⸀∀⸀ 䈀甀猀 椀搀攀渀琀椀昀椀攀爀㨀 ∀⸀␀昀椀氀愀嬀㈀崀⸀∀⸀ 䐀愀琀攀㨀 ∀⸀␀昀椀氀愀嬀㌀崀⸀∀⸀ 䰀椀猀琀 漀昀 瀀愀猀猀攀渀最攀爀猀㨀 ∀⸀␀昀椀氀愀嬀㐀崀⸀ ∀ 㰀⼀瀀㸀∀㬀ഀ਀紀ഀ਀洀礀猀焀氀椀开挀氀漀猀攀⠀␀挀漀渀攀砀椀漀渀⤀㬀 ഀ਀ഀ਀㼀㸀ഀ਀ഀ਀㰀愀 栀爀攀昀㴀∀栀琀琀瀀㨀⼀⼀氀漀挀愀氀栀漀猀琀⼀䈀甀猀倀䠀倀⼀椀渀搀攀砀⸀栀琀洀氀∀㸀 㰀昀漀渀琀 挀漀氀漀爀㴀∀⌀挀挀　　　　∀㸀㰀猀琀爀漀渀最㸀䜀漀 戀愀挀欀 琀漀 琀栀攀 洀愀椀渀 瀀愀最攀㰀⼀猀琀爀漀渀最㸀㰀⼀昀漀渀琀㸀ഀ਀㰀戀爀㸀ഀ਀㰀戀爀㸀