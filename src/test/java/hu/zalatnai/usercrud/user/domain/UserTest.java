package hu.zalatnai.usercrud.user.domain;

import java.time.Instant;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

    @Mock
    private UserMemento mock;

    private String name = "name";
    private Instant created = Instant.ofEpochSecond(1456098614L);
    private Instant modified = Instant.ofEpochMilli(1456098627L);
    private LocalDate dateOfBirth = LocalDate.of(1972, 4, 24);

    @InjectMocks
    private User user;

    @Before
    public void setUp() throws Exception {
        when(mock.getName()).thenReturn(name);
        when(mock.getCreated()).thenReturn(created);
        when(mock.getDateOfBirth()).thenReturn(dateOfBirth);
        when(mock.getModified()).thenReturn(modified);
    }

    @Test
    public void getsTheNameFromTheMemento() {
        assertEquals(name, user.getName());
        verify(mock).getName();
    }

    @Test
    public void getsTheDateOfBirthFromTheMemento() {
        assertEquals(dateOfBirth, user.getDateOfBirth());
        verify(mock).getDateOfBirth();
    }

    @Test
    public void getsTheCreationTimeFromTheMemento() {
        assertEquals(created, user.getCreated());
        verify(mock).getCreated();
    }

    @Test
    public void getsTheLastModificationDateFromTheMemento() {
        assertEquals(modified, user.getModified());
        verify(mock).getModified();
    }
}