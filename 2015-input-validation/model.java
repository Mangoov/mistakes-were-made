public static final String STREET_DATE_PARSING_STRING = "{\"product\": \"availability\": street_date\":"
public static final JsonParser JSON_PARSER = new JsonParser()

public Boolean hasFutureStreetDate(Json input) {
  return JSON_PARSER.parse(STREET_DATE_PARSING_STRING) != null;
}

public DateTime dateTimeFromInput(Json input) {
  String streetDate = (String) JSON_PARSER.parse(STREET_DATE_PARSING_STRING);
  return DateTime.parse(streetDate);
}
