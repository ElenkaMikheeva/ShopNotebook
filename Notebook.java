import java.util.Map;
import java.util.Objects;

public class Notebook {

    private final String name;
    private final int ramSize;
    private final int hddSize;
    private final float screenSize;
    private final String osName;

    public Notebook(String name, int ramSize, int hddSize, float screenSize, String osName) {
        this.name = name;
        this.ramSize = ramSize;
        this.hddSize = hddSize;
        this.screenSize = screenSize;
        this.osName = osName;
    }

    public Boolean Filter(Map<String, String> filters) {
        int i;

        String val = filters.get("ram");
        if (!val.isEmpty()) {
            try {
                i = Integer.parseInt(val);
                if (this.ramSize < i) {
                    return Boolean.FALSE;
                }
            }
            catch (NumberFormatException ignored){}
        }

        val = filters.get("hdd");
        if (!val.isEmpty()) {
            try {
                i = Integer.parseInt(val);
                if (this.hddSize < i) {
                    return Boolean.FALSE;
                }
            }
            catch (NumberFormatException ignored){}
        }

        val = filters.get("screen");
        if (!val.isEmpty()) {
            try {
                i = Integer.parseInt(val);
                if (this.screenSize < i) {
                    return Boolean.FALSE;
                }
            }
            catch (NumberFormatException ignored){}
        }

        val = filters.get("os");
        if (!val.isEmpty() && !Objects.equals(this.osName, val)) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    @Override
    public String toString() {
        return String.format("%s (размер RAM %d Гб, размер HDD %d Гб, размер экрана %.2f\", операционная система - %s)",
        name, ramSize, hddSize, screenSize, osName);
    }

}
