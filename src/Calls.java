import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class Calls {
    private Map<LocalDateTime, String> mapMissedCalls = new TreeMap<>();
    private Map<LocalDateTime, String> mapAcceptedCalls = new TreeMap<>();

    public void addCall(String name, boolean call) {
        LocalDateTime localDateTime = LocalDateTime.now();
        if (!call) {
            mapMissedCalls.put(localDateTime, name);
        } else {
            mapAcceptedCalls.put(localDateTime, name);
        }
    }

    public void showAllCals(boolean call) {
        if (!call) {
            System.out.println("\nВсего пропущенных: " + mapMissedCalls.size());
            int i = 1;
            for (Map.Entry<LocalDateTime, String> entry : mapMissedCalls.entrySet()) {
                System.out.println(i + ". " + entry.getKey().format(DateTimeFormatter.ofPattern("d/MM/uuuu, HH:mm:ss")) + " от аббонента: " + entry.getValue());
                i++;
            }
        } else {
            System.out.println("\nВсего принятых: " + mapAcceptedCalls.size());
            int i = 1;
            for (Map.Entry<LocalDateTime, String> entry : mapAcceptedCalls.entrySet()) {
                System.out.println(i + ". " + entry.getKey().format(DateTimeFormatter.ofPattern("d/MM/uuuu, HH:mm:ss")) + " входящий: " + entry.getValue());
                i++;
            }
        }
    }
}
