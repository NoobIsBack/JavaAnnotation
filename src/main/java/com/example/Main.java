//package com.example;
//
//import java.util.List;
//
//public class Main {
//    private PlanetUtils planetUtils = new PlanetUtils();
//    public static void main(String[] args) {
//
//    }
//
//    static List<Planet> testTwoPlanetsStartWithM() {
//        List<Planet> actual = planetUtils.getPlanetsBeginningWithM(planets);
//        assertThat(actual).hasSize(2);
//        assertThat(actual).extracting(Planet::getName)
//                .containsExactly("Mercury", "Mars");
//    }
//
//    @Test
//    void testFourPlanetsHaveRings() {
//        List<Planet> actual = planetUtils.getPlanetsWithRings(planets);
//        assertThat(actual).hasSize(4);
//        assertThat(actual).extracting(Planet::getName)
//                .containsExactly("Jupiter", "Saturn", "Uranus", "Neptune");
//    }
//
//    @Test
//    void testFourPlanetsHaveMoreThanThreeMoons() {
//        List<Planet> actual = planetUtils.getPlanetsWithMoreThanThreeMoons(planets);
//        assertThat(actual).hasSize(4);
//        assertThat(actual).extracting(Planet::getName)
//                .containsExactly("Jupiter", "Saturn", "Uranus", "Neptune");
//    }
//
//    @Test
//    void testThreePlanetsWithDensityGreaterThanFive() {
//        List<Planet> actual = planetUtils.getPlanetsWithDensityGreaterThanFive(planets);
//        assertThat(actual).hasSize(3);
//        assertThat(actual).extracting(Planet::getName)
//                .containsExactly("Mercury", "Venus", "Earth");
//    }
//}
