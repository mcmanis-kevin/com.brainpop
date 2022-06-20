package utilities.readers;

import function_libraries.SystemLib;
import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;

public class IniReader extends SystemLib {

    Ini ini;

    File file;

    public IniReader(String file) {
        this.file = new File(file);
        try {
            this.ini = new Ini(this.file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public String get_IniValue(String header, String key) {
        return ini.get(header, key);
    }

}
