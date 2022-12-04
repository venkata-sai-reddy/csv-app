package com.ii.csvapp.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.ii.csvapp.entity.Users;

@Service
public class CSVHelper {
	
	static String[] HEADERs = { "Id", "last_name", "first_name", "email", "gender", "dob", "role" };

	public static List<Users> csvToObject(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<Users> UsersList = new ArrayList<>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				Users Users = new Users(Integer.parseInt(csvRecord.get("Id")), csvRecord.get("last_name"),
						csvRecord.get("first_name"), csvRecord.get("email"), csvRecord.get("gender"),
						csvRecord.get("dob"), csvRecord.get("role"));
				UsersList.add(Users);
			}

			return UsersList;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}
}
