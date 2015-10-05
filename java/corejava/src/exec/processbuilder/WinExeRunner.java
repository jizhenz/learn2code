/**
 * 
 */
package exec.processbuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jizhen Zhao
 *
 */
public class WinExeRunner {

    private static final Logger logger = LoggerFactory.getLogger(WinExeRunner.class);

    private static final String userDir = System.getProperty("user.home");
    //private static final String tempDir = System.getProperty("java.io.tmpdir");
    private List<String> command = null;
    private String workDir = null;
    private BufferedWriter logWriter = null;
    private BufferedWriter logStdout = null;
    private BufferedWriter logStderr = null;

    public WinExeRunner(final List<String> command, final String workDir) {
        this.command = command;
        this.workDir = workDir;
    }

    public WinExeRunner(final List<String> command) {
        this(command, userDir);
    }

    public WinExeRunner(final String[] command, final String workDir) {
        this(Arrays.asList(command), workDir);
    }

    public WinExeRunner(final String[] command) {
        this(Arrays.asList(command), userDir);
    }

    public void run() throws IOException, InterruptedException {

        ProcessBuilder builder = new ProcessBuilder(command);
        builder.directory(new File(this.workDir));
        
        String line;
        OutputStream stdin = null;
        InputStream stderr = null;
        InputStream stdout = null;
        
        writeStartInfo();
        
        final Process process = builder.start();
        stdin = process.getOutputStream();
        stderr = process.getErrorStream();
        stdout = process.getInputStream();

        // "write" the parms into stdin
        line = "\n";
        stdin.write(line.getBytes());
        stdin.flush();

        // clean up if any output in stdout
        BufferedReader brCleanUp =
                new BufferedReader(new InputStreamReader(stdout));
        while ((line = brCleanUp.readLine()) != null) {
            writeStdout(line);
        }
        brCleanUp.close();

        // clean up if any output in stderr
        brCleanUp =
                new BufferedReader(new InputStreamReader(stderr));
        while ((line = brCleanUp.readLine()) != null) {
            writeStderr(line);
        }
        brCleanUp.close();
        process.waitFor();
        
        writeEndInfo();
    }
    
    private String commandToString() {
        return Arrays.toString(command.toArray(new String[command.size()]));
    }
    
    private void writeStartInfo() throws IOException {
        logger.info("[] Start to RUN:");
        if (logWriter != null) {
            logWriter.write("[] Start to RUN:\n");
        }
        String line = commandToString();
        logger.info("[] " + line);
        if (logWriter != null) {
            logWriter.write("[] " + line + "\n");
        }
    }
    
    private void writeEndInfo() throws IOException {
        logger.info("[] Finished!");
        if (logWriter != null) {
            logWriter.write("[] Finished!\n");
        }
    }
    
    private void writeStdout(String line) throws IOException {
        logger.info("[Stdout] " + line);
        if (logWriter != null) {
            logWriter.write("[Stdout] " + line + "\n");
        }
        if (logStdout != null) {
            logStdout.write("" + line + "\n");
        }
    }
    
    private void writeStderr(String line) throws IOException {
        logger.info("[Stderr] " + line);
        if (logWriter != null) {
            logWriter.write("[Stderr] " + line + "\n");
        }
        if (logStderr != null) {
            logStderr.write("" + line + "\n");
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] command_03 = new String[] {
                "\"C:\\Program Files\\Microsoft SQL Server\\110\\Tools\\Binn\\SQLCMD.EXE\"",
                "-S",
                "cupwd02a2000.wellsfargo.com,11000",
                "-d",
                "mars_Dev03",
                "-i",
                "C:\\Users\\u343266\\Documents\\tmp\\MCR-7059-DBDeploy\\SqlScript_Rel_148\\RUN_1\\MARS\\010_HuanhuaPan_MCR-6535_RS_Changes.sql",
                "-o",
                "C:\\Users\\u343266\\Documents\\tmp\\MCR-7059-DBDeploy\\Log\\sql_run.log",
                "-E"
        };
        WinExeRunner runner = new WinExeRunner(command_03);
        try {
            runner.run();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setLogWriter(BufferedWriter logWriter, BufferedWriter logStdout, BufferedWriter logStderr) {
        this.logWriter = logWriter;
        this.logStdout = logStdout;
        this.logStderr = logStderr;
    }

}
