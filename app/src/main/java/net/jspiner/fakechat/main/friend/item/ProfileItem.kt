package net.jspiner.fakechat.main.friend.item

abstract class ProfileItem(
        open val userId: String,
        open val profileImage: String,
        open val name: String,
        open val statusMessage: String
): ListItem()