package net.jspiner.fakechat.main.friend.item

data class MyProfileItem(
    override val profileId: Int,
    override val profileImage: String,
    override val name: String,
    override val statusMessage: String
) : ProfileItem(profileId, profileImage, name, statusMessage) {

    companion object {
        val EMPTY = MyProfileItem(
            -1,
            "",
            "계정을 생성 해주세요.",
            ""
        )
    }
}