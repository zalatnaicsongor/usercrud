package hu.zalatnai.usercrud.user.domain;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(User.class)
public class UserTest {

    private Instant now = Instant.ofEpochSecond(33333333L);
    private String name = "name";
    private Instant created = Instant.ofEpochSecond(1111111L);
    private Instant modified = Instant.ofEpochMilli(2222222L);
    private LocalDate dateOfBirth = LocalDate.of(1972, 4, 24);
    private User user = new User(new BasicUserMemento(
        UUID.fromString("72680b57-6f0f-4f0d-ba22-5dfcd52eb4e2"),
        name,
        dateOfBirth,
        created,
        modified
    ));

    @Before
    public void setUp() throws Exception {
        mockStatic(Instant.class);
        when(Instant.now()).thenReturn(now);
    }
    //property getters are omitted

    //changing a users name
    @Test(expected = IllegalArgumentException.class)
    public void throwsIfTryingToClearAUsersName() {
        user.changeName("");
    }

    @Test
    public void canChangeAUsersName() { //assumption: a name contains at least one character
        user.changeName("a");
        assertEquals("a", user.getName());
    }

    @Test
    public void changingAUsersNameBumpsTheModificationTime() {
        user.changeName("a");
        assertEquals(now, user.getModified());

        //verify that the current time has been requested - bit of a strange syntax
        PowerMockito.verifyStatic();
        Instant.now();
    }

    //changing a users date of birth
    @Test(expected = IllegalArgumentException.class)
    public void throwsIfTryingToClearAUsersDateOfBirth() {
        user.changeDateOfBirth(null);
    }

    @Test
    public void canChangeAUsersDateOfBirth() {
        LocalDate newDate = LocalDate.of(2003, 12, 2);
        user.changeDateOfBirth(newDate);
        assertEquals(newDate, user.getDateOfBirth());
    }

    @Test
    public void changingAUsersDateOfBirthBumpsTheModificationTime() {
        user.changeDateOfBirth(LocalDate.of(2012, 2, 2));
        assertEquals(now, user.getModified());

        //verify that the current time has been requested - bit of a strange syntax
        PowerMockito.verifyStatic();
        Instant.now();
    }


    //Utility class to facilitate testing. No mocking is should be applied here since UserMemento is a pure value object.
    private static class BasicUserMemento implements UserMemento {
        private UUID id;
        private String name;
        private LocalDate dateOfBirth;
        private Instant created;
        private Instant modified;

        public BasicUserMemento(UUID id, String name, LocalDate dateOfBirth, Instant created, Instant modified) {
            this.id = id;
            this.name = name;
            this.dateOfBirth = dateOfBirth;
            this.created = created;
            this.modified = modified;
        }

        @Override
        public UUID getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

        @Override
        public void setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        @Override
        public Instant getCreated() {
            return created;
        }

        @Override
        public void setCreated(Instant created) {
            this.created = created;
        }

        @Override
        public Instant getModified() {
            return modified;
        }

        @Override
        public void setModified(Instant modified) {
            this.modified = modified;
        }
    }
}