package harmonie;

import java.io.*;
import javax.sound.midi.*;

public class MidiWriter {
	
	
	private static final int VELOCITY = 64;

	public static void encodeMidi(int[] partition, String s) throws Exception {
		File outputFile = new File(s);
		int k = 0;
		Sequence sequence = new Sequence(Sequence.PPQ, 1, 4);
		for (int i = 0; i < 4; i++) {
			Track track = sequence.createTrack();
			switch (i) {
			case (0):
				track.add(instrument(73, 1));
				k = 0;
				break;
			case (1):
				track.add(instrument(11, 2));
				k = 2;
				break;
			case (2):
				track.add(instrument(12, 3));
				k = 4;
				break;
			case (3):
				track.add(instrument(32, 4));
				k = 5;
				break;
			}
			int d;
			int h = 0;
			for (int j = 0; j < partition.length; j++) {
				d = (Encoder.decode(partition[j]))[k + 1];
				switch ((Encoder.decode(partition[j]))[k]) {
				case (0):
					track.add(noteOn(36, h, i + 1));
					track.add(noteOff(36, h + d, i + 1));
					break;
				case (1):
					track.add(noteOn(38, h, i + 1));
					track.add(noteOff(38, h + d, i + 1));
					break;
				case (2):
					track.add(noteOn(40, h, i + 1));
					track.add(noteOff(40, h + d, i + 1));
					break;
				case (3):
					track.add(noteOn(41, h, i + 1));
					track.add(noteOff(41, h + d, i + 1));
					break;
				case (4):
					track.add(noteOn(43, h, i + 1));
					track.add(noteOff(43, h + d, i + 1));
					break;
				case (5):
					track.add(noteOn(45, h, i + 1));
					track.add(noteOff(45, h + d, i + 1));
					break;
				case (6):
					track.add(noteOn(47, h, i + 1));
					track.add(noteOff(47, h + d, i + 1));
					break;
				case (7):
					track.add(noteOn(48, h, i + 1));
					track.add(noteOff(48, h + d, i + 1));
					break;
				case (8):
					track.add(noteOn(50, h, i + 1));
					track.add(noteOff(50, h + d, i + 1));
					break;
				case (9):
					track.add(noteOn(52, h, i + 1));
					track.add(noteOff(52, h + d, i + 1));
					break;
				case (10):
					track.add(noteOn(53, h, i + 1));
					track.add(noteOff(53, h + d, i + 1));
					break;
				case (11):
					track.add(noteOn(55, h, i + 1));
					track.add(noteOff(55, h + d, i + 1));
					break;
				case (12):
					track.add(noteOn(57, h, i + 1));
					track.add(noteOff(57, h + d, i + 1));
					break;
				case (13):
					track.add(noteOn(59, h, i + 1));
					track.add(noteOff(59, h + d, i + 1));
					break;
				case (14):
					track.add(noteOn(60, h, i + 1));
					track.add(noteOff(60, h + d, i + 1));
					break;
				case (15):
					track.add(noteOn(62, h, i + 1));
					track.add(noteOff(62, h + d, i + 1));
					break;
				case (16):
					track.add(noteOn(64, h, i + 1));
					track.add(noteOff(64, h + d, i + 1));
					break;
				case (17):
					track.add(noteOn(65, h, i + 1));
					track.add(noteOff(65, h + d, i + 1));
					break;
				case (18):
					track.add(noteOn(67, h, i + 1));
					track.add(noteOff(67, h + d, i + 1));
					break;
				case (19):
					track.add(noteOn(69, h, i + 1));
					track.add(noteOff(69, h + d, i + 1));
					break;
				case (20):
					track.add(noteOn(71, h, i + 1));
					track.add(noteOff(71, h + d, i + 1));
					break;
				case (21):
					track.add(noteOn(72, h, i + 1));
					track.add(noteOff(72, h + d, i + 1));
					break;
				case (22):
					track.add(noteOn(74, h, i + 1));
					track.add(noteOff(74, h + d, i + 1));
					break;
				case (23):
					track.add(noteOn(76, h, i + 1));
					track.add(noteOff(76, h + d, i + 1));
					break;
				case (24):
					track.add(noteOn(77, h, i + 1));
					track.add(noteOff(77, h + d, i + 1));
					break;
				case (25):
					track.add(noteOn(79, h, i + 1));
					track.add(noteOff(79, h + d, i + 1));
					break;
				case (26):
					track.add(noteOn(81, h, i + 1));
					track.add(noteOff(81, h + d, i + 1));
					break;
				case (27):
					track.add(noteOn(83, h, i + 1));
					track.add(noteOff(83, h + d, i + 1));
					break;
				}
				h += d;
			}
		}
		MidiSystem.write(sequence, 1, outputFile);
	}

	private static MidiEvent noteOn(int nKey, long lTick, int canal)
			throws InvalidMidiDataException {
		return createNoteEvent(ShortMessage.NOTE_ON, nKey, VELOCITY, lTick,
				canal);
	}

	private static MidiEvent noteOff(int nKey, long lTick, int canal)
			throws InvalidMidiDataException {
		return createNoteEvent(ShortMessage.NOTE_OFF, nKey, 0, lTick, canal);
	}

	private static MidiEvent instrument(int instrument, int canal)
			throws InvalidMidiDataException {
		return createNoteEvent(ShortMessage.PROGRAM_CHANGE, instrument, 0, 0,
				canal);
	}

	private static MidiEvent createNoteEvent(int nCommand, int nKey, int nVelocity,
			long lTick, int canal) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(nCommand, canal, nKey, nVelocity);
		return new MidiEvent(message, lTick);
	}
}