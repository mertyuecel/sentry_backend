package de.novatec.springbootsentry.userfeedback.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFeedback {
    private String sentryId;
    private String userName;
    private String email;
    private String comment;
}
