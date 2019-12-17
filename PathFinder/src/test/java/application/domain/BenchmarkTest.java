package application.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class BenchmarkTest {
    
    private Benchmark benchmark;
    private Routefinder routefinder;
    private Filereader filereader;
    
    @Before
    public void setUp() {
        routefinder = new Routefinder();
        benchmark = new Benchmark(routefinder);
        filereader = new Filereader();
        routefinder.setMap(filereader.readMapFile("map1.map", 512, 512));
        benchmark.setIterations(5);
        
    }
    
    @Test
    public void benchmarkChangesValues() {
        benchmark.startBenchmark();
        assertFalse(benchmark.getAstarTime() == 0);
        assertFalse(benchmark.getDijkstraTime() == 0);
        assertFalse(benchmark.getDfsTime() == 0);
        assertFalse(benchmark.getAvgAstarPathLength() == 0);
        assertFalse(benchmark.getAvgDijkstraPathLength() == 0);
        assertFalse(benchmark.getAvgDfsPathLength() == 0);
        assertFalse(benchmark.getAvgAstarStepsTaken() == 0);
        assertFalse(benchmark.getAvgDijkstraStepsTaken() == 0);
        assertFalse(benchmark.getAvgDfsStepsTaken() == 0);
    }
    
}
