package piesarentsquare.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LibertyServerTest {

    // method to run Maven commands
    private void runMavenCommand(String command) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder("mvn", command);
        // builder.redirectErrorStream(true); // redirect error stream to standard output
        Process process = builder.start();
        process.waitFor();

        int exitCode = process.exitValue();
        assertEquals(0, exitCode, "Maven command failed with exit code: " + exitCode);

        System.out.println("Maven command '" + command + "' executed successfully.");
    }

    @Test
    @Timeout(20)
    void testStartAndStopLiberty() {
        try {

            runMavenCommand("liberty:start");

            runMavenCommand("liberty:stop");

        } catch (IOException | InterruptedException e) {
            fail("Exception during execution: " + e.getMessage());
        }
    }
}


