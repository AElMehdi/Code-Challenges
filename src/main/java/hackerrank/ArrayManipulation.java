package hackerrank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

class ArrayManipulation {


    static ParsedProperties parse(String pathToFile) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(pathToFile));

        Optional<String> firstLine = lines.findFirst();
        String[] parsedProps = null;
        if (firstLine.isPresent()) {
            parsedProps = firstLine.get().split(" ");
        }

        return new ParsedProperties(Integer.parseInt(parsedProps[0]),
                Integer.parseInt(parsedProps[1]));
    }

    static class ParsedProperties {
        private long arraySize;
        private long numberOfOperations;

        ParsedProperties(int arrySize, int numberOperations) {
            this.arraySize = arrySize;
            this.numberOfOperations = numberOperations;
        }

        public long getArraySize() {
            return arraySize;
        }

        public long getNumberOfOperations() {
            return numberOfOperations;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ParsedProperties that = (ParsedProperties) o;
            return arraySize == that.arraySize &&
                    numberOfOperations == that.numberOfOperations;
        }

        @Override
        public int hashCode() {
            return Objects.hash(arraySize, numberOfOperations);
        }
    }


}
