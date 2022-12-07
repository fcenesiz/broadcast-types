## ordered-receiver

``priority:`` to make a order between receivers with having same named actions


```
with usage2() method,
priority: ReceiverB > ReceiverC > ReceiverA > ReceiverD

1. weather_state : sunshine 
2. curtain_state : open 
3. window_state  : open 
4. breath_state  : take_a_deep_breath

abortBroadcast() method will cut the broadcasts,
if this method used on ReceiverC, ReceiverA and ReceiverD will not called
```

## dynamic-receiver

dynamicly registered broadcastreceivers on activity

```kotlin
override fun onResume() {
    super.onResume()
    val intentFilter = IntentFilter()
    intentFilter.addAction(Intent.ACTION_TIME_TICK)
    registerReceiver(myTimeTickReceiver, intentFilter)
}

override fun onPause() {
    super.onPause()
    unregisterReceiver(myTimeTickReceiver)
}
```

## sticky-broadcast
!Deprecated ```sendStickyBroadcast()```

sticky broadcasts are a special type of broadcast for which the sent intent object(s) remains in the cache after the broadcast is complete.

Custom sticky broadcasts should not be used. They provide no security (anyone can access them), no protection (anyone can modify them), and many other problems. The recommended pattern is to use a non-sticky broadcast to report that something has changed, with another mechanism for apps to retrieve the current value whenever desired.
