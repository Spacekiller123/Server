package me.spacekiller.data;

public enum Ban {
	SECOND("s", 0), MINUTE("m", 1), HOUR("h", 60), DAY("d", 1440), WEEK("w",
			10080), MONTH("month", 43200), YEAR("y", 518400);

	public String name;
	public int multi;
	static long sec;

	private Ban(String n, int mult) {
		this.name = n;
		this.multi = mult;
	}

	public static long getTicks(String format, int time) {
		try {
			sec = time * 60;
		} catch (NumberFormatException ex) {
			return 0L;
		}
		for (Ban unit : values()) {
			if (format.startsWith(unit.name)) {
				return Ban.sec = sec * (unit.multi * 1000L);
			}
		}
		return 0L;
	}

	public static String getTimeConvert(long endOfBan) {
		String message = "";

		long now = System.currentTimeMillis();
		long diff = endOfBan - now;
		int seconds = (int) (diff / 1000L);

		if (seconds >= 86400) {
			int days = seconds / 86400;
			seconds %= 86400;
			message = message + days + " Tag(e) ";
		}
		if (seconds >= 3600) {
			int hours = seconds / 3600;
			seconds %= 3600;
			message = message + hours + " Stunde(n) ";
		}
		if (seconds >= 60) {
			int min = seconds / 60;
			seconds %= 60;
			message = message + min + " Minute(n) ";
		}
		if (seconds >= 0) {
			message = message + seconds + " Sekunde(n) ";
		}
		return message;
	}
}