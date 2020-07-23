package persistence;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp>{

	public Timestamp convertToDatabaseColumn(LocalDateTime dateTime) {
		return (dateTime == null) ? null : Timestamp.valueOf(dateTime);
	}

	public LocalDateTime convertToEntityAttribute(Timestamp dateTime) {
		return (dateTime == null) ? null : dateTime.toLocalDateTime();
	}

}
