package net.jspiner.fakechat.main.friend.viewHolder

import android.view.ViewGroup
import net.jspiner.ask.ui.base.BaseViewHolder
import net.jspiner.ask.util.loadSquirclely
import net.jspiner.fakechat.databinding.ItemMyProfileBinding
import net.jspiner.fakechat.main.friend.item.MyProfileItem

class MyProfileViewHolder(parent: ViewGroup, layoutResId: Int) :
        BaseViewHolder<ItemMyProfileBinding, MyProfileItem>(parent, layoutResId) {

    override fun setData(data: MyProfileItem) {
        super.setData(data)

        binding.profileImage.loadSquirclely(data.profileImage)
        binding.profile = data
    }
}