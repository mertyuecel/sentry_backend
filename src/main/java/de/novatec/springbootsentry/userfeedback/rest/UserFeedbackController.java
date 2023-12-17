package de.novatec.springbootsentry.userfeedback.rest;

import de.novatec.springbootsentry.userfeedback.model.UserFeedback;
import io.sentry.Sentry;
import io.sentry.protocol.SentryId;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userFeedback")
public class UserFeedbackController {

    @PostMapping("/createIssue")
    public void create(@RequestBody UserFeedback userFeedback) {
        Sentry.captureUserFeedback(new io.sentry.UserFeedback(
                new SentryId(userFeedback.getSentryId()),
                userFeedback.getUserName(),
                userFeedback.getEmail(),
                userFeedback.getComment()));
    }

}
