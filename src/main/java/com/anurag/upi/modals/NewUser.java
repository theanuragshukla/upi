package com.anurag.upi.modals;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewUser {
        private final String name;
        public String getName() {
            return name;
        }
        public NewUser(@JsonProperty("name") String name) {
            this.name = name;
        }

    }
