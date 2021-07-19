package com.gmail.okooko24816.contributorlist

import kotlinx.serialization.Serializable

@Serializable
data class Contributor(
    val login:String,
    val id:String,
    val node_id:String,
    val avatar_url:String,
    val gravatar_id:String,
    val url:String,
    val html_url:String,
    val follower_url:String,
    val following_url:String,
    val gists_url:String,
    val starred_url:String,
    val subscriptions_url:String,
    val organizations_url:String,
    val repos_url:String,
    val events_url:String,
    val received_events_url:String,
    val type:String,
    val site_admin:String,
    val contributions:String
)