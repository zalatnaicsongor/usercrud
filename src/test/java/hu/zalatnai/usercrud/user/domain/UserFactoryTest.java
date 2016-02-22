package hu.zalatnai.usercrud.user.domain;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserFactory.class)
public class UserFactoryTest {

    @Mock
    private UserMementoFactory userMementoFactory;

    @Mock
    private UserMemento userMemento;

    @InjectMocks
    private UserFactory userFactory;

    private String name = "name";
    private LocalDate dateOfBirth = LocalDate.of(1980, 1, 1);
    private UUID id = UUID.fromString("9b6c3407-c045-4706-8d0b-8c4dc963c597");
    private Instant now = Instant.ofEpochSecond(123456L);

    @Before
    public void setUp() {
        PowerMockito.mockStatic(Instant.class);
        PowerMockito.mockStatic(UUID.class);
        PowerMockito.when(Instant.now()).thenReturn(now);
        PowerMockito.when(UUID.randomUUID()).thenReturn(id);

        when(userMementoFactory.create(id, name, dateOfBirth, now, now)).thenReturn(userMemento);

        when(userMemento.getId()).thenReturn(id);
        when(userMemento.getName()).thenReturn(name);
        when(userMemento.getDateOfBirth()).thenReturn(dateOfBirth);
        when(userMemento.getCreated()).thenReturn(now);
        when(userMemento.getModified()).thenReturn(now);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotCreateAUserWithoutAName() {
        userFactory.create("", dateOfBirth);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotCreateAUserWithoutADateOfBirth() {
        userFactory.create(name, null);
    }

    @Test
    public void theCreatedUserHasTheValidNameSet() {
        User user = userFactory.create(name, dateOfBirth);
        assertEquals(name, user.getName());
    }

    @Test
    public void theCreatedUserHasTheDateOfBirthSet() {
        User user = userFactory.create(name, dateOfBirth);
        assertEquals(dateOfBirth, user.getDateOfBirth());
    }

    @Test
    public void theCreatedUserHasGotARandomlyGeneratedUUIDAsItsIdentifier() {
        User user = userFactory.create(name, dateOfBirth);
        assertEquals(id, user.getId());

        PowerMockito.verifyStatic();
        UUID.randomUUID();
    }

    @Test
    public void theCreatedUsersTimeOfCreationAndLastModificationIsTheTimeWhenTheUserWasCreated() {
        User user = userFactory.create(name, dateOfBirth);
        assertEquals(now, user.getCreated());
        assertEquals(now, user.getModified());

        PowerMockito.verifyStatic();
        Instant.now();
    }

}