## ordered-receiver

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