package net.jspiner.fakechat.main.friend.viewHolder

import android.view.ViewGroup
import net.jspiner.ask.ui.base.BaseViewHolder
import net.jspiner.ask.util.loadSquirclely
import net.jspiner.fakechat.databinding.ItemFriendProfileBinding
import net.jspiner.fakechat.main.friend.item.FriendProfileItem

class FriendViewHolder(parent: ViewGroup, layoutResId: Int) :
        BaseViewHolder<ItemFriendProfileBinding, FriendProfileItem>(parent, layoutResId) {

    override fun setData(data: FriendProfileItem) {
        super.setData(data)

        binding.profileImage.loadSquirclely(data.profileImage)
        binding.profile = data
    }
}