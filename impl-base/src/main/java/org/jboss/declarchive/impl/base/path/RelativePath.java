/*
 * JBoss, Home of Professional Open Source

 * Copyright 2009, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.declarchive.impl.base.path;

import org.jboss.declarchive.api.Path;

/**
 * RelativePath
 *
 * @author <a href="mailto:aslak@conduct.no">Aslak Knutsen</a>
 * @version $Revision: $
 */
public class RelativePath extends PrefixPath
{
   private Path basePath;

   public RelativePath(Path basePath, Path context)
   {
      this(basePath, context.get());
   }

   public RelativePath(Path basePath, String context)
   {
      this(basePath.get(), context);
   }

   public RelativePath(String basePath, String context)
   {
      super(PathUtil.fixRelativePath(context));
      this.basePath = new BasePath(basePath);
   }

   @Override
   String getPrefix()
   {
      return basePath.get();
   }

}
