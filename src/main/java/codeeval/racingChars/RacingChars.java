package codeeval.racingChars;

class RacingChars {

   private static final String GATE = "_";
   private static final String CHECKPOINT = "C";
   private static final String LEFT = "/";
   private static final String RIGHT = "\\";
   private static final String STRAIGHT = "|";

   private static boolean startingPoint = true;

   private static int previousPassingIndex;
   private static int checkpointIndex;
   private static int gateIndex;

   static String getInTrack(String track) {
      return isNotNullOrEmpty(track) ? raceOn(track) : track;
   }

   private static String raceOn(String track) {
      StringBuilder trackEasyToDriveIn = getReadyForTheRace(track);

      if (doesCheckpointExist()) {
         return driveThroughObstacles(trackEasyToDriveIn, checkpointIndex);
      }

      if (doesGateExist()) {
         return driveThroughObstacles(trackEasyToDriveIn, gateIndex);
      }

      return track;
   }

   private static StringBuilder getReadyForTheRace(String track) {
      StringBuilder trackEasyToDriveIn = new StringBuilder(track);
      checkpointIndex = track.indexOf(CHECKPOINT);
      gateIndex = track.indexOf(GATE);
      return trackEasyToDriveIn;
   }

   private static String driveThroughObstacles(StringBuilder trackEasyToDriveIn, int obstacleIndex) {
      if (startingPoint) {
         setPreviousPassingIndexAtStart(obstacleIndex);
      }

      if (obstacleIndex < previousPassingIndex) {
         return turnTheWheel(LEFT, trackEasyToDriveIn, obstacleIndex);
      }

      if (obstacleIndex > previousPassingIndex) {
         return turnTheWheel(RIGHT, trackEasyToDriveIn, obstacleIndex);
      }

      return turnTheWheel(STRAIGHT, trackEasyToDriveIn, obstacleIndex);
   }

   private static String turnTheWheel(String direction, StringBuilder trackEasyToDriveIn, int obstacleIndex) {
      String result = trackEasyToDriveIn
            .replace(obstacleIndex, obstacleIndex + 1, direction)
            .toString();
      previousPassingIndex = obstacleIndex;
      return result;
   }

   private static void setPreviousPassingIndexAtStart(int obstacleIndex) {
      previousPassingIndex = obstacleIndex;
      startingPoint = false;
   }

   private static boolean isNotNullOrEmpty(String track) {
      return (track != null && !track.isEmpty());
   }

   private static boolean doesCheckpointExist() {
      return checkpointIndex >= 0;
   }

   private static boolean doesGateExist() {
      return gateIndex >= 0;
   }
}
