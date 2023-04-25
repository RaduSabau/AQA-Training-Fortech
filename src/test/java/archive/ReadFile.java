package archive;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.List;

public class ReadFile {
    public String readFileToString(String fileName) {
        String content;
        try {
            content = IOUtils.toString(Paths.get(fileName).toUri(), StandardCharsets.UTF_8);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content;
    }

        public List<String> readFileToList(String fileName) {
            String content;
            try {
                content = IOUtils.toString(Paths.get(fileName).toUri(), StandardCharsets.UTF_8);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return content.lines().toList();
        }
}
