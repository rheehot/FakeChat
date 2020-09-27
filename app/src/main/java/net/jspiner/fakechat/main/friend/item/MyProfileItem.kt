package net.jspiner.fakechat.main.friend.item

data class MyProfileItem(
        override val userId: String,
        override val profileImage: String,
        override val name: String,
        override val statusMessage: String
) : ProfileItem(userId, profileImage, name, statusMessage)