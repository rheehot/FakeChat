package net.jspiner.fakechat.main.friend.item

import net.jspiner.ask.ui.base.Diffable

abstract class ListItem: Diffable {
    override fun isSameItem(other: Diffable) = false // TODO
}