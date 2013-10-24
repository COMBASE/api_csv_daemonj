package net.combase.cloud.api.lekkerland.reader;

import java.util.Arrays;

public class DispatchNotificationReaderImpl extends AbstractReader {

	final static int[] a10Fields = {
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

	final static int[] l10Fields = {
			DispatchNotificationLineType.L10_001_RECORDART.getCode(),
			DispatchNotificationLineType.L10_002_LIEFERDATUM.getCode(),
			DispatchNotificationLineType.L10_003_LIEFERSCHEIN_NUMMER.getCode(),
			DispatchNotificationLineType.L10_004_LIEFERSCHEINART.getCode(),
			DispatchNotificationLineType.L10_005_LIEFERSCHEIN_NUMMER_ALLES
					.getCode() };
	final static int[] l20Fields = {
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

	final static int[] l25Fields = {
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
	final static int[] s01Fields = {
			DispatchNotificationLineType.S01_001_RECORDART.getCode(),
			DispatchNotificationLineType.S01_002_DATENART.getCode(),
			DispatchNotificationLineType.S01_003_VERSION.getCode(),
			DispatchNotificationLineType.S01_004_PARTNERNUMMER.getCode(),
			DispatchNotificationLineType.S01_005_ERSTELLUNGSDATUM.getCode(),
			DispatchNotificationLineType.S01_006_ERSTELLUNGSZEIT.getCode(),
			DispatchNotificationLineType.S01_007_ANZAHL_DATENSAETZE.getCode(),
			DispatchNotificationLineType.S01_008_LAUFNUMMER.getCode(),
			DispatchNotificationLineType.S01_009_MAILADRESSE.getCode() };

	public DispatchNotificationReaderImpl() {
		super();
	}

	public void readA10(final String sCurrentLine) {
		final String[] readLine = readLine(sCurrentLine, a10Fields);
		System.out.println(Arrays.deepToString(readLine));
	}

	public void readL25(final String sCurrentLine) {
		final String[] readLine = readLine(sCurrentLine, l25Fields);
		System.out.println(Arrays.deepToString(readLine));
	}

	public void readL20(final String sCurrentLine) {
		final String[] readLine = readLine(sCurrentLine, l20Fields);
		System.out.println(Arrays.deepToString(readLine));
	}

	public void readL10(final String sCurrentLine) {
		final String[] readLine = readLine(sCurrentLine, l10Fields);
		System.out.println(Arrays.deepToString(readLine));
	}
	

	public void readS01(final String sCurrentLine) {
		final String[] readLine = readLine(sCurrentLine, s01Fields);
		System.out.println(Arrays.deepToString(readLine));
	}

}
