#!/bin/bash
#   Copyright (c) 2015 Magnet Systems, Inc.
#
#   Licensed under the Apache License, Version 2.0 (the "License");
#   you may not use this file except in compliance with the License.
#   You may obtain a copy of the License at
#
#       http://www.apache.org/licenses/LICENSE-2.0
#
#   Unless required by applicable law or agreed to in writing, software
#   distributed under the License is distributed on an "AS IS" BASIS,
#   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#   See the License for the specific language governing permissions and
#   limitations under the License.
#
old_home_101=mmx-standalone-dist-1.0.1
old_home=mmx-standalone-dist-1.5.7
log="/Users/$USER/mmx-standalone-dist_installlog.txt"

if [ -d "/Users/$USER/$old_home_101" ]; then
    echo "old $old_home_101 detected" >> $log
    cd /Users/$USER/$old_home_101
    ./mmx.sh stop >> $log 2>&1
    echo "stopped existing servers" >> $log
fi

if [ -d "/Users/$USER/$old_home" ]; then
    echo "old $old_home detected" >> $log
    cd /Users/$USER/$old_home
    ./mmx.sh stop >> $log 2>&1
    echo "stopped existing servers" >> $log
fi
exit 0
