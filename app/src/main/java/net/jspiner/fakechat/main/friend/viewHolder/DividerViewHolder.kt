package net.jspiner.fakechat.main.friend.viewHolder

import android.view.ViewGroup
import net.jspiner.ask.ui.base.BaseViewHolder
import net.jspiner.fakechat.databinding.ItemDividerBinding
import net.jspiner.fakechat.main.friend.item.DividerItem

class DividerViewHolder(parent: ViewGroup, layoutResId: Int) :
        BaseViewHolder<ItemDividerBinding, DividerItem>(parent, layoutResId) {

    override fun setData(data: DividerItem) {
        super.setData(data)
        binding.item = data
    }
}