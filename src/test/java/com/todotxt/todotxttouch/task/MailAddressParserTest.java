package com.todotxt.todotxttouch.task;



import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class MailAddressParserTest {


    @Test
    public void parseNullMailReturnsEmptyList() {
        var actual = MailAddressParser.getInstance().parse(null);

        assertThat(actual).isEmpty();
    }

    @Test
    public void parseEmptyStringReturnsEmptyList() {
        var actual = MailAddressParser.getInstance().parse("");

        assertThat(actual).isEmpty();
    }

    @Test
    public void parseValidMailReturnsCorrectSameEmail() {
        var expected = "newmail@mail.com";

        var actual = MailAddressParser.getInstance().parse(expected);

        assertThat(actual).containsExactly(expected);
    }

    @Test
    public void parseAllValidEmailsReturnsAllEmails() {
        var emails = "newmail@mail.com;other@mail.com";
        var expected = Set.of("newmail@mail.com", "other@mail.com");

        var actual = MailAddressParser.getInstance().parse(emails);

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    public void parseSomeValidEmailsAndOtherInvalidEmailsReturnsOnlyValidEmails() {
        var emails = "newmail@mail.com;other@mail.com;invalid;yetanotheremail@email.com";
        var expected = Set.of("newmail@mail.com", "other@mail.com", "yetanotheremail@email.com");

        var actual = MailAddressParser.getInstance().parse(emails);

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    public void invalidMailReturnsEmptyList() {
        var emails = "invalidEmail;otherinvalidemail;@invalid";

        var actual = MailAddressParser.getInstance().parse(emails);

        assertThat(actual).isEmpty();
    }
}
