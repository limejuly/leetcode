func isPathCrossing(path string) bool {
	mp := map[string]bool{}
	x := 0
	y := 0
	mp[toString(x, y)] = true
	for _, ch := range path {
		switch ch {
		case 'N':
			y++
		case 'S':
			y--
		case 'E':
			x++
		case 'W':
			x--
		}
		str := toString(x, y)
		if _, ok := mp[str]; ok {
			return true
		} else {
			mp[str] = true
		}
	}
	return false
}

func toString(x, y int) string {
	return strconv.Itoa(x) + "-" + strconv.Itoa(y)
}