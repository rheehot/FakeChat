package net.jspiner.fakechat.main.friend

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import net.jspiner.ask.ui.base.BaseAdapter
import net.jspiner.ask.ui.base.BaseViewHolder
import net.jspiner.fakechat.R
import net.jspiner.fakechat.main.friend.item.DividerItem
import net.jspiner.fakechat.main.friend.item.FriendProfileItem
import net.jspiner.fakechat.main.friend.item.ListItem
import net.jspiner.fakechat.main.friend.item.MyProfileItem
import net.jspiner.fakechat.main.friend.viewHolder.DividerViewHolder
import net.jspiner.fakechat.main.friend.viewHolder.FriendViewHolder
import net.jspiner.fakechat.main.friend.viewHolder.MyProfileViewHolder

class FriendListAdapter : BaseAdapter<ListItem>() {

    private var myProfile = MyProfileItem.EMPTY
    private var friendProfileList: List<FriendProfileItem> = emptyList()

    override fun onCreateViewHolderInternal(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<out ViewDataBinding, ListItem> {
        @Suppress("UNCHECKED_CAST")
        return when (viewType) {
            VIEW_TYPE_DIVIDER -> DividerViewHolder(parent, R.layout.item_divider)
            VIEW_TYPE_MY_PROFILE -> MyProfileViewHolder(parent, R.layout.item_my_profile)
            VIEW_TYPE_FRIEND_PROFILE -> FriendViewHolder(parent, R.layout.item_friend_profile)
            else -> throw UnsupportedOperationException("")
        } as BaseViewHolder<out ViewDataBinding, ListItem>
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<ViewDataBinding, ListItem>,
        position: Int
    ) {
        holder.setData(dataList[position])
    }

    override fun getItemViewType(position: Int) = when (dataList[position]) {
        is DividerItem -> VIEW_TYPE_DIVIDER
        is MyProfileItem -> VIEW_TYPE_MY_PROFILE
        is FriendProfileItem -> VIEW_TYPE_FRIEND_PROFILE
        else -> throw UnsupportedOperationException("")
    }

    fun updateMyProfile(profile: MyProfileItem) {
        this.myProfile = profile
        updateDisplayList()
    }

    fun updateFriendProfileList(list: List<FriendProfileItem>) {
        this.friendProfileList = list
        updateDisplayList()
    }

    private fun updateDisplayList() {
        update(
            listOf(myProfile, DividerItem("친구 ${friendProfileList.count()}")) +
                    friendProfileList
        )
    }

    companion object {
        const val VIEW_TYPE_DIVIDER = 1
        const val VIEW_TYPE_MY_PROFILE = 2
        const val VIEW_TYPE_FRIEND_PROFILE = 3
    }

}