package file;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;

import static java.nio.file.Files.mismatch;
import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.assertThat;

public class FilesShould {

    @Test
    void compare_files() throws URISyntaxException, IOException {
        Path pathFile1 = Path.of(requireNonNull(getClass().getClassLoader().getResource("file1.txt")).toURI());
        Path pathFile2 = Path.of(requireNonNull(getClass().getClassLoader().getResource("file2.txt")).toURI());
        Path pathFile3 = Path.of(requireNonNull(getClass().getClassLoader().getResource("file3.txt")).toURI());
        Path pathFile4 = Path.of(requireNonNull(getClass().getClassLoader().getResource("file4.txt")).toURI());

        assertThat(mismatch(pathFile1, pathFile2)).isEqualTo(-1);
        assertThat(mismatch(pathFile1, pathFile3)).isEqualTo(5);
        assertThat(mismatch(pathFile3, pathFile4)).isEqualTo(9);
    }

}
