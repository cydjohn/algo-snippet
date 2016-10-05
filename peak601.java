static double findMaximumXP(Location playerPosition, long numPokeBalls, PokeMap PokeMap) {
	PriorityQueue<Double> pq = new PriorityQueue<Double>(Collections.reverseOrder());
	double res = 0;
	int x = playerPosition.getX();
	int y = playerPosition.getY();
	long m = PokeMap.getSizeX();
	long n = PokeMap.getSizeY();
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			double dis = sqrt((x - i)*(x - i) + (y - j)*(y - j));
			double xp = PokeMap.getValue(i, j);
			pq.add(xp / log10(xp));
		}
	}
	for (int i = 0; i < numPokeBalls; i++) {
		res += pq.remove();
	}
	return roundToPlaces(res, 3);
}