package comet.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HistData {
	private long timestamp;
	private double low;
	private double high;
	private double open;
	private double close;
	private double volumeTo;
	private double volumeFrom;
	
	public HistData() {
		
	}
	
	public HistData(long timestamp, double low, double high, double open, double close, double volumeTo, double volumeFrom) {
		this.timestamp = timestamp;
		this.low = low;
		this.high = high;
		this.open = open;
		this.close = close;
		this.volumeTo = volumeTo;
		this.volumeFrom = volumeFrom;
	}
	
	public String timestampToDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date(getTimestamp()*1000));
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public double getVolumeTo() {
		return volumeTo;
	}

	public void setVolumeTo(double volumeTo) {
		this.volumeTo = volumeTo;
	}

	public double getVolumeFrom() {
		return volumeFrom;
	}

	public void setVolumeFrom(double volumeFrom) {
		this.volumeFrom = volumeFrom;
	}
}
