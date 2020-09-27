package net.jspiner.fakechat.main.friend.item

data class FriendProfileItem(
    override val profileId: Int,
    override val profileImage: String,
    override val name: String,
    override val statusMessage: String
) : ProfileItem(profileId, profileImage, name, statusMessage)