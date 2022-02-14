import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    @org.junit.jupiter.api.Test
    public void Employee_Success() {
        Employee employee = new Employee(3, "Bill", "Gates", "Israel", 66);
        Assertions.assertEquals(employee.id, 3);
        Assertions.assertEquals(employee.firstName, "Bill");
        Assertions.assertEquals(employee.lastName, "Gates");
        Assertions.assertEquals(employee.country, "Israel");
        Assertions.assertEquals(employee.age, 66);
    }

    @org.junit.jupiter.api.Test
    public void parseCSV_List_Mapping_Success() {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        List<Employee> list = Main.parseCSV(columnMapping, fileName);
        Assertions.assertNotNull(list);
        Assertions.assertEquals(1, list.get(0).id);
        Assertions.assertEquals("John", list.get(0).firstName);
        Assertions.assertEquals("Smith", list.get(0).lastName);
        Assertions.assertEquals("USA", list.get(0).country);
        Assertions.assertEquals(25, list.get(0).age);
    }

    @org.junit.jupiter.api.Test
    public void listToJson_Return_String_Success() {
        List<Employee> list = new ArrayList<>(Arrays.asList(new Employee(1, "Linus", "Torvalds", "Finland", 52)));
        String json = Main.listToJson(list);
        Assertions.assertEquals("[{\"id\":1,\"firstName\":\"Linus\",\"lastName\":\"Torvalds\",\"country\":\"Finland\",\"age\":52}]", json);
    }
}
