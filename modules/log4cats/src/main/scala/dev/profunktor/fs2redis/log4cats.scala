/*
 * Copyright 2018-2019 ProfunKtor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.profunktor.fs2redis

import dev.profunktor.fs2redis.effect.Log
import io.chrisdavenport.log4cats.Logger

object log4cats {

  implicit def log4CatsInstance[F[_]](implicit L: Logger[F]): Log[F] =
    new Log[F] {
      def info(msg: => String): F[Unit]  = L.info(msg)
      def error(msg: => String): F[Unit] = L.error(msg)
    }

}