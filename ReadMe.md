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