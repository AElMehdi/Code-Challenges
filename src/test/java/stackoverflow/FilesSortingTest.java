package stackoverflow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.Files.createFile;
import static java.nio.file.Files.list;
import static java.util.Arrays.stream;
import static java.util.Comparator.naturalOrder;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class FilesSortingTest {

    private File file;

    @BeforeEach
    void setUp() {
        file = new File(getClass().getClassLoader().getResource("files").getFile());
    }

    @Test
    void should_sort_files_by_name(@TempDir Path temp) throws IOException {
        Path first = temp.resolve("01. first file");
        Path fourth = temp.resolve("4. fourth file");
        Path third = temp.resolve("3. third file");
        Path fifth = temp.resolve("5. fifth file");
        Path second = temp.resolve("02. second file");

        createFile(first);
        createFile(fourth);
        createFile(third);
        createFile(fifth);
        createFile(second);

        List<String> files = list(temp)
                .map(FilesSortingTest::apply)
                .sorted(naturalOrder())
                .collect(toList());

        assertThat(files).containsExactly("01. first file",
                "02. second file",
                "3. third file",
                "4. fourth file",
                "5. fifth file");
    }

    private static String apply(Path path) {
        return path.getFileName().toString();
    }


    @Test
    void should_sort_file_names_from_a_folder_old_api() {
        List<String> files = stream(requireNonNull(file.listFiles()))
                .map(File::getName)
                .sorted(naturalOrder())
                .collect(toList());

        assertThat(files).containsExactly("1. Selenium Introduction", "2. Complete Guide",
                "3. Brush up Java concepts", "38. Docker Sensei");
    }

    // Answer to the following stackoverflow question:
    // https://stackoverflow.com/questions/59204214/sorting-elements-file-array
    @Test
    void should_sort_files_from_a_folder_old_api_using_stream() {
        List<File> sortedFiles = stream(requireNonNull(file.listFiles()))
                .sorted(File::compareTo)
                .collect(toList());

        assertThat(sortedFiles)
                .extracting("name")
                .containsExactly("1. Selenium Introduction", "2. Complete Guide", "3. Brush up Java concepts", "38. Docker Sensei");
    }

    @Test
    void should_sort_files_from_a_folder_old_api_using_arrays_sort() {
        File[] sortedFiles = file.listFiles();

        // One liner
        Arrays.sort(sortedFiles);

        assertThat(sortedFiles)
                .extracting("name")
                .containsExactly("1. Selenium Introduction", "2. Complete Guide", "3. Brush up Java concepts", "38. Docker Sensei");
    }
}
