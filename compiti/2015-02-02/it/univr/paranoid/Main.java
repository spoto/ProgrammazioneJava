package it.univr.paranoid;

public class Main {
	private static App angryPigs;
	private static App angryPigsV2;
	private static App angryPigsV3;
	private static App pMail;
	private static App pMailV2;
	private static App facelook;
	private static App facelookV2;
	private static App facelookV3;
	private static App facelookV4;
	
	private static Store officialMarketplace;

	private static Device samsing;
	private static Device iphong;
	
	public static void main(String[] args) {
		createApps();
		createStores();
		createDevices();

		System.out.println("Sul device samsing dall'official marketplace posso installare:");
		for (App app: officialMarketplace.getAppsFor(samsing))
			System.out.println(app);

		System.out.println("\nSul device iphong dall'official marketplace posso installare:");
		for (App app: officialMarketplace.getAppsFor(iphong))
			System.out.println(app);

		System.out.println("\nProvo ad installare " + facelook + " su iphong");
		iphong.install(facelook);
		System.out.println("Provo ad installare " + facelookV2 + " su iphong");
		iphong.install(facelookV2);
		System.out.println("Provo ad installare " + pMailV2 + " su iphong");
		iphong.install(pMailV2);

		System.out.println("\nEcco che cosa è installato su iphong:");
		for (App app: iphong.getInstalledApps())
			System.out.println(app);

		System.out.println("\nProvo ad installare " + facelookV3 + " su iphong");
		iphong.install(facelookV3);
	}

	private static void createApps() {
		angryPigs = new App("Angry Pigs", OS.FLOATING_HIPPO, 1);
		angryPigsV2 = new App("Angry Pigs", OS.FLOATING_HIPPO, 2);
		angryPigsV3 = new App("Angry Pigs",OS.FLOATING_HIPPO, 3);
		pMail = new App("P-Mail", OS.LITTLE_LION, 1);
		pMailV2 = new App("P-Mail", OS.RUNNING_TIGER, 2);
		facelook = new App("Facelook", OS.RUNNING_TIGER, 1);
		facelookV2 = new App("Facelook", OS.RUNNING_TIGER, 2);
		facelookV3 = new App("Facelook", OS.ACKWARD_BEAR, 3);
		facelookV4 = new App("Facelook", OS.FLOATING_HIPPO, 4);
	}

	private static void createStores() {
		 officialMarketplace = new Store("Officially Paranoid");
		 officialMarketplace.add(angryPigs);
		 officialMarketplace.add(angryPigsV2);
		 officialMarketplace.add(angryPigsV3);
		 officialMarketplace.add(pMailV2);
		 officialMarketplace.add(pMail);
		 officialMarketplace.add(facelook);
		 officialMarketplace.add(facelookV4);
	}

	private static void createDevices() {
		samsing = new Device(OS.FLOATING_HIPPO);
		iphong = new Device(OS.RUNNING_TIGER);
	}
}