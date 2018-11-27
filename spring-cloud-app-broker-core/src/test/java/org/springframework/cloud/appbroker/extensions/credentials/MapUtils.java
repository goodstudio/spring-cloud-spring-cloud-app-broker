/*
 * Copyright 2016-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.appbroker.extensions.credentials;

import java.util.Arrays;
import java.util.Map;

final class MapUtils {
	private MapUtils() {
	}

	@SuppressWarnings("unchecked")
	static Map<String, Object> getNestedMap(Map<String, Object> map, String... keys) {
		if (keys.length > 0 && map.containsKey(keys[0])) {
			Map<String, Object> nested = (Map<String, Object>) map.get(keys[0]);
			String[] newKeys = Arrays.copyOfRange(keys, 1, keys.length);
			return getNestedMap(nested, newKeys);
		}
		return map;
	}
}
