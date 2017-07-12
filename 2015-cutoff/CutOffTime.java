
public Boolean isBeforeCutoff(LocalTime locationCutoffTime, Zone zone) {
  ZonedDateTime zonedCutoffTime = ZonedDateTime(LocalDate.now(), locationCutoffTime, zone);

  return zonedCutoffTime.isBefore(ZonedDateTime.now(zone));
}

// Test always passes locally
public void testIsBeforeCutoffReturnsTrue {
  assertTrue isBeforeCutoff(LocalTime.parse("00:00:00"), ZoneId.of("America/New_York"));
}

// Test passes:
// Test run on 03/03/2020 at 12:00:00 UTC
// zonedCutoffTime = (03/03/2020, 00:00:00, "America/New_York")
// zonedCutoffTime = 03/03/2020 00:00:00 UTC-05
// ZonedDateTime.now(zone) = 03/03/2020 07:00:00 UTC-05
// 03/03/2020 00:00:00 UTC-05 is before 03/03/2020 07:00:00 UTC-05


// Test fails:
// Test run on 03/03/2020 at 01:00:00 UTC
// zonedCutoffTime = (03/03/2020, 00:00:00, "America/New_York")
// zonedCutoffTime = 03/03/2020 00:00:00 UTC-05
// ZonedDateTime.now(zone) = 03/02/2020 20:00:00 UTC-05
// 03/03/2020 00:00:00 UTC-05 is not Before 03/02/2020 20:00:00 UTC-05