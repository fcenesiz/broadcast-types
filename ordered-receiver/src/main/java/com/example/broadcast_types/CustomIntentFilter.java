package com.example.broadcast_types;

import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.List;

public class CustomIntentFilter extends IntentFilter {

    public CustomIntentFilter(Builder builder){
            setPriority(builder.priority);
            builder.actions.forEach(this::addAction);
    }

    public static class Builder {

        private List<String> actions = new ArrayList<>();
        private int priority;

        public Builder setPriority(int priority) {
            this.priority = priority;
            return this;
        }

        public Builder addAction(String action){
            actions.add(action);
            return this;
        }

        public CustomIntentFilter build(){
            return new CustomIntentFilter(this);
        }
    }
}
