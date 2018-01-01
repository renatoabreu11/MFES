package Rally.tests;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class MyTestRunner {
    public static void main(String[] args) {

        IO.println("Initializing Test Runner");
        new SponsorTest().Run();
        new ManufacturerTest().Run();
        new CarTest().Run();
        new DriverTest().Run();
        new TeamTest().Run();
        new PerformanceTest().Run();
        new StageTest().Run();
        new RallyTest().Run();
        new ChampionshipTest().Run();
        new UseCasesTest().Run();
        IO.println("Finalizing Test Runner");
    }

    public MyTestRunner() {}

    public String toString() {

        return "MyTestRunner{}";
    }
}
