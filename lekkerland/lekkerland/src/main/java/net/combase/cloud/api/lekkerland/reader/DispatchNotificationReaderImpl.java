package net.combase.cloud.api.lekkerland.reader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DispatchNotificationReaderImpl extends AbstractReader {

	private final static int[] a10Fields = {
			DispatchNotificationLineType.A10_001_RECORDART.getCode(),
			DispatchNotificationLineType.A10_002_DATENART.getCode(),
			DispatchNotificationLineType.A10_003_VERSION.getCode(),
			DispatchNotificationLineType.A10_004_PARTNERART.getCode(),
			DispatchNotificationLineType.A10_005_PARTNERNUMMER.getCode(),
			DispatchNotificationLineType.A10_006_UEBERMITTLUNGSART.getCode(),
			DispatchNotificationLineType.A10_007_PAKETNUMMER.getCode(),
			DispatchNotificationLineType.A10_008_ZIP_FLAG.getCode(),
			DispatchNotificationLineType.A10_009_RESTART_NUMMER.getCode(),
			DispatchNotificationLineType.A10_010_ABSENDENDES_SYSTEM.getCode(),
			DispatchNotificationLineType.A10_011_EMPFANGENDES_SYSTEM.getCode() };

	private final static int[] l10Fields = {
			DispatchNotificationLineType.L10_001_RECORDART.getCode(),
			DispatchNotificationLineType.L10_002_LIEFERDATUM.getCode(),
			DispatchNotificationLineType.L10_003_LIEFERSCHEIN_NUMMER.getCode(),
			DispatchNotificationLineType.L10_004_LIEFERSCHEINART.getCode(),
			DispatchNotificationLineType.L10_005_LIEFERSCHEIN_NUMMER_ALLES
					.getCode() };
	private final static int[] l20Fields = {
			DispatchNotificationLineType.L20_001_RECORDART.getCode(),
			DispatchNotificationLineType.L20_002_POSITIONSNUMMER.getCode(),
			DispatchNotificationLineType.L20_003_ARTIKEL_NR_BESTELLT.getCode(),
			DispatchNotificationLineType.L20_004_EAN_NR_BESTELLT.getCode(),
			DispatchNotificationLineType.L20_005_MENGE_BESTELLT.getCode(),
			DispatchNotificationLineType.L20_006_ARTIKEL_NR_GELIEFERT.getCode(),
			DispatchNotificationLineType.L20_007_EAN_NR_LE_GELIEFERT.getCode(),
			DispatchNotificationLineType.L20_008_EAN_NR_VE_GELIEFERT.getCode(),
			DispatchNotificationLineType.L20_009_MENGE_GELIEFERT.getCode(),
			DispatchNotificationLineType.L20_010_GEWICHTSCODE.getCode(),
			DispatchNotificationLineType.L20_011_FEHLLIEFERCODE.getCode(),
			DispatchNotificationLineType.L20_012_ARTIKELART.getCode(),
			DispatchNotificationLineType.L20_013_AKTIONSKENNZEICHEN.getCode(),
			DispatchNotificationLineType.L20_014_NETTOCODE.getCode(),
			DispatchNotificationLineType.L20_015_TEKTURCODE.getCode(),
			DispatchNotificationLineType.L20_016_VE_LE.getCode(),
			DispatchNotificationLineType.L20_017_MWST_FLAG.getCode(),
			DispatchNotificationLineType.L20_018_ABGABEPREIS_NETTO_.getCode(),
			DispatchNotificationLineType.L20_019_CODE_PREISEINGABE_MAN
					.getCode(),
			DispatchNotificationLineType.L20_020_VERKAUFSPREIS_.getCode(),
			DispatchNotificationLineType.L20_021_ABGABEPREIS_BRUTTO.getCode(),
			DispatchNotificationLineType.L20_022_MUTATIONSCODE.getCode(),
			DispatchNotificationLineType.L20_023_USEGO_STAMMNUMMER.getCode(),
			DispatchNotificationLineType.L20_024_ARTIKELTEXT.getCode(),
			DispatchNotificationLineType.L20_025_LIEFEREINHEIT.getCode(),
			DispatchNotificationLineType.L20_026_VERKAUFSEINHEIT.getCode(),
			DispatchNotificationLineType.L20_027_INHALT_EINHEIT.getCode(),
			DispatchNotificationLineType.L20_028_INHALT.getCode(),
			DispatchNotificationLineType.L20_029_PFAND.getCode(),
			DispatchNotificationLineType.L20_030_HAUPTGRUPPE.getCode(),
			DispatchNotificationLineType.L20_031_WARENGRUPPE.getCode(),
			DispatchNotificationLineType.L20_032_ORDERSATZVERCODUNG.getCode(),
			DispatchNotificationLineType.L20_033_TIEFPREISCODE.getCode(),
			DispatchNotificationLineType.L20_034_EIGENMARKENCODE.getCode(),
			DispatchNotificationLineType.L20_035_PFLICHTSORTIMENT.getCode(),
			DispatchNotificationLineType.L20_036_MATERIALKLASSE.getCode(),
			DispatchNotificationLineType.L20_037_BESTELLNUMMER_KUNDE.getCode(),
			DispatchNotificationLineType.L20_038_ERSATZARTIKELNUMMER.getCode(),
			DispatchNotificationLineType.L20_039_BESTELLNUMMER_KD.getCode(),
			DispatchNotificationLineType.L20_040_KUNDENAUFTRAGSNUMMER_LL
					.getCode(),
			DispatchNotificationLineType.L20_041_POSITION_KD_AUFTRAG_LL
					.getCode(),
			DispatchNotificationLineType.L20_042_STABILE_ARTIKELNUMMER
					.getCode(),
			DispatchNotificationLineType.L20_043_MWST_SATZ.getCode(),
			DispatchNotificationLineType.L20_044_MWST_BETRAG.getCode(),
			DispatchNotificationLineType.L20_045_LIEFEREINHEIT.getCode(),
			DispatchNotificationLineType.L20_046_VERKAUFSEINHEIT.getCode(),
			DispatchNotificationLineType.L20_047_MHD.getCode() };

	private final static int[] l25Fields = {
			DispatchNotificationLineType.L25_001_RECORDART.getCode(),
			DispatchNotificationLineType.L25_002_ARTIKELNUMMER.getCode(),
			DispatchNotificationLineType.L25_003_EAN_NUMMER_VE.getCode(),
			DispatchNotificationLineType.L25_004_ID_DER_HIERARCHIESTUFE
					.getCode(),
			DispatchNotificationLineType.L25_005_TEXTKUERZEL_DER_STUFE
					.getCode(),
			DispatchNotificationLineType.L25_006_UMRFAKTOR_HOEHERE_STUFE
					.getCode(),
			DispatchNotificationLineType.L25_007_TEXTKUERZEL_HOEHERE_STUFE
					.getCode(),
			DispatchNotificationLineType.L25_008_ARTIKELTEXT.getCode(),
			DispatchNotificationLineType.L25_009_VERKAUFSPREIS.getCode(),
			DispatchNotificationLineType.L25_010_TEXTKUERZEL_DER_STUFE
					.getCode(),
			DispatchNotificationLineType.L25_011_TEXTKUERZEL_HOEHERE_STUFE
					.getCode() };
	private final static int[] s01Fields = {
			DispatchNotificationLineType.S01_001_RECORDART.getCode(),
			DispatchNotificationLineType.S01_002_DATENART.getCode(),
			DispatchNotificationLineType.S01_003_VERSION.getCode(),
			DispatchNotificationLineType.S01_004_PARTNERNUMMER.getCode(),
			DispatchNotificationLineType.S01_005_ERSTELLUNGSDATUM.getCode(),
			DispatchNotificationLineType.S01_006_ERSTELLUNGSZEIT.getCode(),
			DispatchNotificationLineType.S01_007_ANZAHL_DATENSAETZE.getCode(),
			DispatchNotificationLineType.S01_008_LAUFNUMMER.getCode(),
			DispatchNotificationLineType.S01_009_MAILADRESSE.getCode() };
	private final int[] e01Fields = {
			DispatchNotificationLineType.E01_001_RECORDART.getCode(),
			DispatchNotificationLineType.E01_002_DATENART.getCode(),
			DispatchNotificationLineType.E01_003_VERSION.getCode(),
			DispatchNotificationLineType.E01_004_PARTNERNUMMER.getCode(),
			DispatchNotificationLineType.E01_005_ERSTELLUNGSDATUM.getCode(),
			DispatchNotificationLineType.E01_006_ERSTELLUNGSZEIT.getCode(),
			DispatchNotificationLineType.E01_007_ANZAHL_DATENSAETZE.getCode(),
			DispatchNotificationLineType.E01_008_LAUFNUMMER.getCode() };
	private final int[] z90Fields = {
			DispatchNotificationLineType.Z90_001_RECORDART.getCode(),
			DispatchNotificationLineType.Z90_002_DATENART.getCode(),
			DispatchNotificationLineType.Z90_003_VERSION.getCode(),
			DispatchNotificationLineType.Z90_004_PARTNERART.getCode(),
			DispatchNotificationLineType.Z90_005_PARTNERNUMMER.getCode(),
			DispatchNotificationLineType.Z90_006_UEBERMITTLUNGSART.getCode(),
			DispatchNotificationLineType.Z90_007_PAKETNUMMER.getCode(),
			DispatchNotificationLineType.Z90_008_ZIP_FLAG.getCode(),
			DispatchNotificationLineType.Z90_009_RESTART_NUMMER.getCode(),
			DispatchNotificationLineType.Z90_010_ABSENDENDES_SYSTEM.getCode(),
			DispatchNotificationLineType.Z90_011_EMPFANGENDES_SYSTEM.getCode() };

	public String[] readA10(final String sCurrentLine) {
		return readLine(sCurrentLine, a10Fields);
	}

	public String[] readL25(final String sCurrentLine) {
		return readLine(sCurrentLine, l25Fields);
	}

	public String[] readL20(final String sCurrentLine) {
		return readLine(sCurrentLine, l20Fields);
	}

	public String[] readL10(final String sCurrentLine) {
		return readLine(sCurrentLine, l10Fields);
	}

	public String[] readS01(final String sCurrentLine) {
		return readLine(sCurrentLine, s01Fields);
	}

	public String[] readE01(final String sCurrentLine) {
		return readLine(sCurrentLine, e01Fields);
	}

	public String[] readZ90(final String sCurrentLine) {
		return readLine(sCurrentLine, z90Fields);
	}

	public Date getDate(final String date, final String time) {
		int[] dateFields = { 4, 2, 2 };
		int[] timeFields = { 2, 2, 2 };
		String[] readLine = readLine(date, dateFields);
		String[] readLine2 = readLine(time, timeFields);
	    SimpleDateFormat sdfToDate = new SimpleDateFormat( "dd.MM.yyyy HH:mm:ss" );
	    Date ret = null;
		try {
			ret = sdfToDate.parse(readLine[2]+"."+readLine[1]+"."+readLine[0]+" "+readLine2[0]+":"+readLine2[1]+":"+readLine2[2]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}

}
