openapi: 3.0.1
info:
  title: OpenAPI definition
  version: v0
servers:
  - url: http://localhost:8080
    description: Generated server url
paths:
  /tasks/{id}:
    get:
      tags:
        - task-controller
      operationId: getTask
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
            format: int64
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/Task'
    put:
      tags:
        - task-controller
      operationId: putTask
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
            format: int64
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Task'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/Task'
    delete:
      tags:
        - task-controller
      operationId: deleteTask
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: integer
            format: int64
      responses:
        '200':
          description: OK
  /tasks:
    get:
      tags:
        - task-controller
      operationId: getTasks
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Task'
    post:
      tags:
        - task-controller
      operationId: addTask
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Task'
        required: true
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/Task'
  /v2/api-docs:
    get:
      tags:
        - swagger-2-controller-web-mvc
      operationId: getDocumentation
      parameters:
        - name: group
          in: query
          required: false
          schema:
            type: string
        - name: servletRequest
          in: query
          required: true
          schema:
            type: object
            properties:
              method:
                type: string
              contextPath:
                type: string
              session:
                type: object
                properties:
                  id:
                    type: string
                  creationTime:
                    type: integer
                    format: int64
                  sessionContext:
                    type: object
                    properties:
                      ids:
                        type: object
                        deprecated: true
                    deprecated: true
                  valueNames:
                    type: array
                    deprecated: true
                    items:
                      type: string
                      deprecated: true
                  attributeNames:
                    type: object
                  servletContext:
                    type: object
                    properties:
                      classLoader:
                        type: object
                        properties:
                          name:
                            type: string
                          registeredAsParallelCapable:
                            type: boolean
                          parent:
                            type: object
                            properties:
                              name:
                                type: string
                              registeredAsParallelCapable:
                                type: boolean
                              unnamedModule:
                                type: object
                                properties:
                                  name:
                                    type: string
                                  descriptor:
                                    type: object
                                    properties:
                                      open:
                                        type: boolean
                                      automatic:
                                        type: boolean
                                  named:
                                    type: boolean
                                  annotations:
                                    type: array
                                    items:
                                      type: object
                                  declaredAnnotations:
                                    type: array
                                    items:
                                      type: object
                                  packages:
                                    uniqueItems: true
                                    type: array
                                    items:
                                      type: string
                                  layer:
                                    type: object
                              definedPackages:
                                type: array
                                items:
                                  type: object
                                  properties:
                                    name:
                                      type: string
                                    annotations:
                                      type: array
                                      items:
                                        type: object
                                    declaredAnnotations:
                                      type: array
                                      items:
                                        type: object
                                    sealed:
                                      type: boolean
                                    specificationTitle:
                                      type: string
                                    specificationVersion:
                                      type: string
                                    specificationVendor:
                                      type: string
                                    implementationTitle:
                                      type: string
                                    implementationVersion:
                                      type: string
                                    implementationVendor:
                                      type: string
                              defaultAssertionStatus:
                                type: boolean
                                writeOnly: true
                          unnamedModule:
                            type: object
                            properties:
                              name:
                                type: string
                              descriptor:
                                type: object
                                properties:
                                  open:
                                    type: boolean
                                  automatic:
                                    type: boolean
                              named:
                                type: boolean
                              annotations:
                                type: array
                                items:
                                  type: object
                              declaredAnnotations:
                                type: array
                                items:
                                  type: object
                              packages:
                                uniqueItems: true
                                type: array
                                items:
                                  type: string
                              layer:
                                type: object
                          definedPackages:
                            type: array
                            items:
                              type: object
                              properties:
                                name:
                                  type: string
                                annotations:
                                  type: array
                                  items:
                                    type: object
                                declaredAnnotations:
                                  type: array
                                  items:
                                    type: object
                                sealed:
                                  type: boolean
                                specificationTitle:
                                  type: string
                                specificationVersion:
                                  type: string
                                specificationVendor:
                                  type: string
                                implementationTitle:
                                  type: string
                                implementationVersion:
                                  type: string
                                implementationVendor:
                                  type: string
                          defaultAssertionStatus:
                            type: boolean
                            writeOnly: true
                      majorVersion:
                        type: integer
                        format: int32
                      minorVersion:
                        type: integer
                        format: int32
                      attributeNames:
                        type: object
                      contextPath:
                        type: string
                      effectiveMajorVersion:
                        type: integer
                        format: int32
                      sessionCookieConfig:
                        type: object
                        properties:
                          name:
                            type: string
                          path:
                            type: string
                          comment:
                            type: string
                          domain:
                            type: string
                          maxAge:
                            type: integer
                            format: int32
                          secure:
                            type: boolean
                          httpOnly:
                            type: boolean
                      sessionTrackingModes:
                        uniqueItems: true
                        type: array
                        writeOnly: true
                        items:
                          type: string
                          enum:
                            - COOKIE
                            - URL
                            - SSL
                      jspConfigDescriptor:
                        type: object
                        properties:
                          jspPropertyGroups:
                            type: array
                            items:
                              type: object
                              properties:
                                buffer:
                                  type: string
                                defaultContentType:
                                  type: string
                                urlPatterns:
                                  type: array
                                  items:
                                    type: string
                                deferredSyntaxAllowedAsLiteral:
                                  type: string
                                errorOnUndeclaredNamespace:
                                  type: string
                                trimDirectiveWhitespaces:
                                  type: string
                                scriptingInvalid:
                                  type: string
                                isXml:
                                  type: string
                                includePreludes:
                                  type: array
                                  items:
                                    type: string
                                pageEncoding:
                                  type: string
                                includeCodas:
                                  type: array
                                  items:
                                    type: string
                                elIgnored:
                                  type: string
                          taglibs:
                            type: array
                            items:
                              type: object
                              properties:
                                taglibLocation:
                                  type: string
                                taglibURI:
                                  type: string
                      effectiveMinorVersion:
                        type: integer
                        format: int32
                      servletContextName:
                        type: string
                      defaultSessionTrackingModes:
                        uniqueItems: true
                        type: array
                        items:
                          type: string
                          enum:
                            - COOKIE
                            - URL
                            - SSL
                      filterRegistrations:
                        type: object
                        additionalProperties:
                          type: object
                          properties:
                            servletNameMappings:
                              type: array
                              items:
                                type: string
                            urlPatternMappings:
                              type: array
                              items:
                                type: string
                            name:
                              type: string
                            className:
                              type: string
                            initParameters:
                              type: object
                              additionalProperties:
                                type: string
                      requestCharacterEncoding:
                        type: string
                      responseCharacterEncoding:
                        type: string
                      virtualServerName:
                        type: string
                      servletRegistrations:
                        type: object
                        additionalProperties:
                          type: object
                          properties:
                            mappings:
                              type: array
                              items:
                                type: string
                            runAsRole:
                              type: string
                            name:
                              type: string
                            className:
                              type: string
                            initParameters:
                              type: object
                              additionalProperties:
                                type: string
                      initParameterNames:
                        type: object
                      effectiveSessionTrackingModes:
                        uniqueItems: true
                        type: array
                        items:
                          type: string
                          enum:
                            - COOKIE
                            - URL
                            - SSL
                      serverInfo:
                        type: string
                      sessionTimeout:
                        type: integer
                        format: int32
                      servletNames:
                        type: object
                        deprecated: true
                      servlets:
                        type: object
                        deprecated: true
                  maxInactiveInterval:
                    type: integer
                    format: int32
                  lastAccessedTime:
                    type: integer
                    format: int64
                  new:
                    type: boolean
              remoteUser:
                type: string
              userPrincipal:
                type: object
                properties:
                  name:
                    type: string
              headerNames:
                type: object
              pathInfo:
                type: string
              queryString:
                type: string
              requestURI:
                type: string
              parts:
                type: array
                items:
                  type: object
                  properties:
                    name:
                      type: string
                    size:
                      type: integer
                      format: int64
                    inputStream:
                      type: object
                    contentType:
                      type: string
                    headerNames:
                      type: array
                      items:
                        type: string
                    submittedFileName:
                      type: string
              servletPath:
                type: string
              cookies:
                type: array
                items:
                  type: object
                  properties:
                    name:
                      type: string
                    value:
                      type: string
                    comment:
                      type: string
                    domain:
                      type: string
                    maxAge:
                      type: integer
                      format: int32
                    path:
                      type: string
                    secure:
                      type: boolean
                    version:
                      type: integer
                      format: int32
                    httpOnly:
                      type: boolean
              trailerFields:
                type: object
                additionalProperties:
                  type: string
              pathTranslated:
                type: string
              requestURL:
                type: object
                properties:
                  length:
                    type: integer
                    format: int32
                    writeOnly: true
                  empty:
                    type: boolean
              authType:
                type: string
              requestedSessionIdValid:
                type: boolean
              requestedSessionIdFromUrl:
                type: boolean
                deprecated: true
              httpServletMapping:
                type: object
                properties:
                  pattern:
                    type: string
                  servletName:
                    type: string
                  mappingMatch:
                    type: string
                    enum:
                      - CONTEXT_ROOT
                      - DEFAULT
                      - EXACT
                      - EXTENSION
                      - PATH
                  matchValue:
                    type: string
              requestedSessionId:
                type: string
              requestedSessionIdFromCookie:
                type: boolean
              requestedSessionIdFromURL:
                type: boolean
              trailerFieldsReady:
                type: boolean
              scheme:
                type: string
              inputStream:
                type: object
                properties:
                  finished:
                    type: boolean
                  ready:
                    type: boolean
                  readListener:
                    type: object
                    writeOnly: true
              protocol:
                type: string
              contentLength:
                type: integer
                format: int32
              locale:
                type: object
                properties:
                  language:
                    type: string
                  script:
                    type: string
                  country:
                    type: string
                  variant:
                    type: string
                  unicodeLocaleAttributes:
                    uniqueItems: true
                    type: array
                    items:
                      type: string
                  unicodeLocaleKeys:
                    uniqueItems: true
                    type: array
                    items:
                      type: string
                  displayLanguage:
                    type: string
                  displayScript:
                    type: string
                  displayCountry:
                    type: string
                  displayVariant:
                    type: string
                  displayName:
                    type: string
                  extensionKeys:
                    uniqueItems: true
                    type: array
                    items:
                      type: string
                  iso3Language:
                    type: string
                  iso3Country:
                    type: string
              localPort:
                type: integer
                format: int32
              contentType:
                type: string
              contentLengthLong:
                type: integer
                format: int64
              attributeNames:
                type: object
              servletContext:
                type: object
                properties:
                  classLoader:
                    type: object
                    properties:
                      name:
                        type: string
                      registeredAsParallelCapable:
                        type: boolean
                      parent:
                        type: object
                        properties:
                          name:
                            type: string
                          registeredAsParallelCapable:
                            type: boolean
                          unnamedModule:
                            type: object
                            properties:
                              name:
                                type: string
                              descriptor:
                                type: object
                                properties:
                                  open:
                                    type: boolean
                                  automatic:
                                    type: boolean
                              named:
                                type: boolean
                              annotations:
                                type: array
                                items:
                                  type: object
                              declaredAnnotations:
                                type: array
                                items:
                                  type: object
                              packages:
                                uniqueItems: true
                                type: array
                                items:
                                  type: string
                              layer:
                                type: object
                          definedPackages:
                            type: array
                            items:
                              type: object
                              properties:
                                name:
                                  type: string
                                annotations:
                                  type: array
                                  items:
                                    type: object
                                declaredAnnotations:
                                  type: array
                                  items:
                                    type: object
                                sealed:
                                  type: boolean
                                specificationTitle:
                                  type: string
                                specificationVersion:
                                  type: string
                                specificationVendor:
                                  type: string
                                implementationTitle:
                                  type: string
                                implementationVersion:
                                  type: string
                                implementationVendor:
                                  type: string
                          defaultAssertionStatus:
                            type: boolean
                            writeOnly: true
                      unnamedModule:
                        type: object
                        properties:
                          name:
                            type: string
                          descriptor:
                            type: object
                            properties:
                              open:
                                type: boolean
                              automatic:
                                type: boolean
                          named:
                            type: boolean
                          annotations:
                            type: array
                            items:
                              type: object
                          declaredAnnotations:
                            type: array
                            items:
                              type: object
                          packages:
                            uniqueItems: true
                            type: array
                            items:
                              type: string
                          layer:
                            type: object
                      definedPackages:
                        type: array
                        items:
                          type: object
                          properties:
                            name:
                              type: string
                            annotations:
                              type: array
                              items:
                                type: object
                            declaredAnnotations:
                              type: array
                              items:
                                type: object
                            sealed:
                              type: boolean
                            specificationTitle:
                              type: string
                            specificationVersion:
                              type: string
                            specificationVendor:
                              type: string
                            implementationTitle:
                              type: string
                            implementationVersion:
                              type: string
                            implementationVendor:
                              type: string
                      defaultAssertionStatus:
                        type: boolean
                        writeOnly: true
                  majorVersion:
                    type: integer
                    format: int32
                  minorVersion:
                    type: integer
                    format: int32
                  attributeNames:
                    type: object
                  contextPath:
                    type: string
                  effectiveMajorVersion:
                    type: integer
                    format: int32
                  sessionCookieConfig:
                    type: object
                    properties:
                      name:
                        type: string
                      path:
                        type: string
                      comment:
                        type: string
                      domain:
                        type: string
                      maxAge:
                        type: integer
                        format: int32
                      secure:
                        type: boolean
                      httpOnly:
                        type: boolean
                  sessionTrackingModes:
                    uniqueItems: true
                    type: array
                    writeOnly: true
                    items:
                      type: string
                      enum:
                        - COOKIE
                        - URL
                        - SSL
                  jspConfigDescriptor:
                    type: object
                    properties:
                      jspPropertyGroups:
                        type: array
                        items:
                          type: object
                          properties:
                            buffer:
                              type: string
                            defaultContentType:
                              type: string
                            urlPatterns:
                              type: array
                              items:
                                type: string
                            deferredSyntaxAllowedAsLiteral:
                              type: string
                            errorOnUndeclaredNamespace:
                              type: string
                            trimDirectiveWhitespaces:
                              type: string
                            scriptingInvalid:
                              type: string
                            isXml:
                              type: string
                            includePreludes:
                              type: array
                              items:
                                type: string
                            pageEncoding:
                              type: string
                            includeCodas:
                              type: array
                              items:
                                type: string
                            elIgnored:
                              type: string
                      taglibs:
                        type: array
                        items:
                          type: object
                          properties:
                            taglibLocation:
                              type: string
                            taglibURI:
                              type: string
                  effectiveMinorVersion:
                    type: integer
                    format: int32
                  servletContextName:
                    type: string
                  defaultSessionTrackingModes:
                    uniqueItems: true
                    type: array
                    items:
                      type: string
                      enum:
                        - COOKIE
                        - URL
                        - SSL
                  filterRegistrations:
                    type: object
                    additionalProperties:
                      type: object
                      properties:
                        servletNameMappings:
                          type: array
                          items:
                            type: string
                        urlPatternMappings:
                          type: array
                          items:
                            type: string
                        name:
                          type: string
                        className:
                          type: string
                        initParameters:
                          type: object
                          additionalProperties:
                            type: string
                  requestCharacterEncoding:
                    type: string
                  responseCharacterEncoding:
                    type: string
                  virtualServerName:
                    type: string
                  servletRegistrations:
                    type: object
                    additionalProperties:
                      type: object
                      properties:
                        mappings:
                          type: array
                          items:
                            type: string
                        runAsRole:
                          type: string
                        name:
                          type: string
                        className:
                          type: string
                        initParameters:
                          type: object
                          additionalProperties:
                            type: string
                  initParameterNames:
                    type: object
                  effectiveSessionTrackingModes:
                    uniqueItems: true
                    type: array
                    items:
                      type: string
                      enum:
                        - COOKIE
                        - URL
                        - SSL
                  serverInfo:
                    type: string
                  sessionTimeout:
                    type: integer
                    format: int32
                  servletNames:
                    type: object
                    deprecated: true
                  servlets:
                    type: object
                    deprecated: true
              reader:
                type: object
              parameterNames:
                type: object
              characterEncoding:
                type: string
              remoteAddr:
                type: string
              asyncContext:
                type: object
                properties:
                  request:
                    type: object
                    properties:
                      scheme:
                        type: string
                      inputStream:
                        type: object
                        properties:
                          finished:
                            type: boolean
                          ready:
                            type: boolean
                          readListener:
                            type: object
                            writeOnly: true
                      protocol:
                        type: string
                      contentLength:
                        type: integer
                        format: int32
                      locale:
                        type: object
                        properties:
                          language:
                            type: string
                          script:
                            type: string
                          country:
                            type: string
                          variant:
                            type: string
                          unicodeLocaleAttributes:
                            uniqueItems: true
                            type: array
                            items:
                              type: string
                          unicodeLocaleKeys:
                            uniqueItems: true
                            type: array
                            items:
                              type: string
                          displayLanguage:
                            type: string
                          displayScript:
                            type: string
                          displayCountry:
                            type: string
                          displayVariant:
                            type: string
                          displayName:
                            type: string
                          extensionKeys:
                            uniqueItems: true
                            type: array
                            items:
                              type: string
                          iso3Language:
                            type: string
                          iso3Country:
                            type: string
                      localPort:
                        type: integer
                        format: int32
                      contentType:
                        type: string
                      contentLengthLong:
                        type: integer
                        format: int64
                      attributeNames:
                        type: object
                      servletContext:
                        type: object
                        properties:
                          classLoader:
                            type: object
                            properties:
                              name:
                                type: string
                              registeredAsParallelCapable:
                                type: boolean
                              parent:
                                type: object
                                properties:
                                  name:
                                    type: string
                                  registeredAsParallelCapable:
                                    type: boolean
                                  unnamedModule:
                                    type: object
                                    properties:
                                      name:
                                        type: string
                                      descriptor:
                                        type: object
                                        properties:
                                          open:
                                            type: boolean
                                          automatic:
                                            type: boolean
                                      named:
                                        type: boolean
                                      annotations:
                                        type: array
                                        items:
                                          type: object
                                      declaredAnnotations:
                                        type: array
                                        items:
                                          type: object
                                      packages:
                                        uniqueItems: true
                                        type: array
                                        items:
                                          type: string
                                      layer:
                                        type: object
                                  definedPackages:
                                    type: array
                                    items:
                                      type: object
                                      properties:
                                        name:
                                          type: string
                                        annotations:
                                          type: array
                                          items:
                                            type: object
                                        declaredAnnotations:
                                          type: array
                                          items:
                                            type: object
                                        sealed:
                                          type: boolean
                                        specificationTitle:
                                          type: string
                                        specificationVersion:
                                          type: string
                                        specificationVendor:
                                          type: string
                                        implementationTitle:
                                          type: string
                                        implementationVersion:
                                          type: string
                                        implementationVendor:
                                          type: string
                                  defaultAssertionStatus:
                                    type: boolean
                                    writeOnly: true
                              unnamedModule:
                                type: object
                                properties:
                                  name:
                                    type: string
                                  descriptor:
                                    type: object
                                    properties:
                                      open:
                                        type: boolean
                                      automatic:
                                        type: boolean
                                  named:
                                    type: boolean
                                  annotations:
                                    type: array
                                    items:
                                      type: object
                                  declaredAnnotations:
                                    type: array
                                    items:
                                      type: object
                                  packages:
                                    uniqueItems: true
                                    type: array
                                    items:
                                      type: string
                                  layer:
                                    type: object
                              definedPackages:
                                type: array
                                items:
                                  type: object
                                  properties:
                                    name:
                                      type: string
                                    annotations:
                                      type: array
                                      items:
                                        type: object
                                    declaredAnnotations:
                                      type: array
                                      items:
                                        type: object
                                    sealed:
                                      type: boolean
                                    specificationTitle:
                                      type: string
                                    specificationVersion:
                                      type: string
                                    specificationVendor:
                                      type: string
                                    implementationTitle:
                                      type: string
                                    implementationVersion:
                                      type: string
                                    implementationVendor:
                                      type: string
                              defaultAssertionStatus:
                                type: boolean
                                writeOnly: true
                          majorVersion:
                            type: integer
                            format: int32
                          minorVersion:
                            type: integer
                            format: int32
                          attributeNames:
                            type: object
                          contextPath:
                            type: string
                          effectiveMajorVersion:
                            type: integer
                            format: int32
                          sessionCookieConfig:
                            type: object
                            properties:
                              name:
                                type: string
                              path:
                                type: string
                              comment:
                                type: string
                              domain:
                                type: string
                              maxAge:
                                type: integer
                                format: int32
                              secure:
                                type: boolean
                              httpOnly:
                                type: boolean
                          sessionTrackingModes:
                            uniqueItems: true
                            type: array
                            writeOnly: true
                            items:
                              type: string
                              enum:
                                - COOKIE
                                - URL
                                - SSL
                          jspConfigDescriptor:
                            type: object
                            properties:
                              jspPropertyGroups:
                                type: array
                                items:
                                  type: object
                                  properties:
                                    buffer:
                                      type: string
                                    defaultContentType:
                                      type: string
                                    urlPatterns:
                                      type: array
                                      items:
                                        type: string
                                    deferredSyntaxAllowedAsLiteral:
                                      type: string
                                    errorOnUndeclaredNamespace:
                                      type: string
                                    trimDirectiveWhitespaces:
                                      type: string
                                    scriptingInvalid:
                                      type: string
                                    isXml:
                                      type: string
                                    includePreludes:
                                      type: array
                                      items:
                                        type: string
                                    pageEncoding:
                                      type: string
                                    includeCodas:
                                      type: array
                                      items:
                                        type: string
                                    elIgnored:
                                      type: string
                              taglibs:
                                type: array
                                items:
                                  type: object
                                  properties:
                                    taglibLocation:
                                      type: string
                                    taglibURI:
                                      type: string
                          effectiveMinorVersion:
                            type: integer
                            format: int32
                          servletContextName:
                            type: string
                          defaultSessionTrackingModes:
                            uniqueItems: true
                            type: array
                            items:
                              type: string
                              enum:
                                - COOKIE
                                - URL
                                - SSL
                          filterRegistrations:
                            type: object
                            additionalProperties:
                              type: object
                              properties:
                                servletNameMappings:
                                  type: array
                                  items:
                                    type: string
                                urlPatternMappings:
                                  type: array
                                  items:
                                    type: string
                                name:
                                  type: string
                                className:
                                  type: string
                                initParameters:
                                  type: object
                                  additionalProperties:
                                    type: string
                          requestCharacterEncoding:
                            type: string
                          responseCharacterEncoding:
                            type: string
                          virtualServerName:
                            type: string
                          servletRegistrations:
                            type: object
                            additionalProperties:
                              type: object
                              properties:
                                mappings:
                                  type: array
                                  items:
                                    type: string
                                runAsRole:
                                  type: string
                                name:
                                  type: string
                                className:
                                  type: string
                                initParameters:
                                  type: object
                                  additionalProperties:
                                    type: string
                          initParameterNames:
                            type: object
                          effectiveSessionTrackingModes:
                            uniqueItems: true
                            type: array
                            items:
                              type: string
                              enum:
                                - COOKIE
                                - URL
                                - SSL
                          serverInfo:
                            type: string
                          sessionTimeout:
                            type: integer
                            format: int32
                          servletNames:
                            type: object
                            deprecated: true
                          servlets:
                            type: object
                            deprecated: true
                      reader:
                        type: object
                      parameterNames:
                        type: object
                      characterEncoding:
                        type: string
                      remoteAddr:
                        type: string
                      serverName:
                        type: string
                      localAddr:
                        type: string
                      parameterMap:
                        type: object
                        additionalProperties:
                          type: array
                          items:
                            type: string
                      asyncStarted:
                        type: boolean
                      asyncSupported:
                        type: boolean
                      localName:
                        type: string
                      dispatcherType:
                        type: string
                        enum:
                          - FORWARD
                          - INCLUDE
                          - REQUEST
                          - ASYNC
                          - ERROR
                      remotePort:
                        type: integer
                        format: int32
                      serverPort:
                        type: integer
                        format: int32
                      locales:
                        type: object
                      secure:
                        type: boolean
                      remoteHost:
                        type: string
                  response:
                    type: object
                    properties:
                      locale:
                        type: object
                        properties:
                          language:
                            type: string
                          script:
                            type: string
                          country:
                            type: string
                          variant:
                            type: string
                          unicodeLocaleAttributes:
                            uniqueItems: true
                            type: array
                            items:
                              type: string
                          unicodeLocaleKeys:
                            uniqueItems: true
                            type: array
                            items:
                              type: string
                          displayLanguage:
                            type: string
                          displayScript:
                            type: string
                          displayCountry:
                            type: string
                          displayVariant:
                            type: string
                          displayName:
                            type: string
                          extensionKeys:
                            uniqueItems: true
                            type: array
                            items:
                              type: string
                          iso3Language:
                            type: string
                          iso3Country:
                            type: string
                      outputStream:
                        type: object
                        properties:
                          ready:
                            type: boolean
                          writeListener:
                            type: object
                            writeOnly: true
                      contentType:
                        type: string
                      contentLength:
                        type: integer
                        format: int32
                        writeOnly: true
                      bufferSize:
                        type: integer
                        format: int32
                      characterEncoding:
                        type: string
                      contentLengthLong:
                        type: integer
                        format: int64
                        writeOnly: true
                      writer:
                        type: object
                      committed:
                        type: boolean
                  timeout:
                    type: integer
                    format: int64
              serverName:
                type: string
              localAddr:
                type: string
              parameterMap:
                type: object
                additionalProperties:
                  type: array
                  items:
                    type: string
              asyncStarted:
                type: boolean
              asyncSupported:
                type: boolean
              localName:
                type: string
              dispatcherType:
                type: string
                enum:
                  - FORWARD
                  - INCLUDE
                  - REQUEST
                  - ASYNC
                  - ERROR
              remotePort:
                type: integer
                format: int32
              serverPort:
                type: integer
                format: int32
              locales:
                type: object
              secure:
                type: boolean
              remoteHost:
                type: string
      responses:
        '200':
          description: OK
          content:
            application/json:
              schema:
                type: string
            application/hal+json:
              schema:
                type: string
  /swagger-resources:
    get:
      tags:
        - api-resource-controller
      operationId: swaggerResources
      responses:
        '200':
          description: OK
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/SwaggerResource'
  /swagger-resources/configuration/ui:
    get:
      tags:
        - api-resource-controller
      operationId: uiConfiguration
      responses:
        '200':
          description: OK
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/UiConfiguration'
  /swagger-resources/configuration/security:
    get:
      tags:
        - api-resource-controller
      operationId: securityConfiguration
      responses:
        '200':
          description: OK
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/SecurityConfiguration'
components:
  schemas:
    Task:
      required:
        - content
      type: object
      properties:
        id:
          type: integer
          format: int64
        content:
          type: string
        creationDate:
          type: string
          format: date
    SwaggerResource:
      type: object
      properties:
        name:
          type: string
        url:
          type: string
        swaggerVersion:
          type: string
        location:
          type: string
          deprecated: true
    UiConfiguration:
      type: object
      properties:
        deepLinking:
          type: boolean
        displayOperationId:
          type: boolean
        defaultModelsExpandDepth:
          type: integer
          format: int32
        defaultModelExpandDepth:
          type: integer
          format: int32
        defaultModelRendering:
          type: string
          enum:
            - example
            - model
        displayRequestDuration:
          type: boolean
        docExpansion:
          type: string
          enum:
            - none
            - list
            - full
        filter:
          type: object
        maxDisplayedTags:
          type: integer
          format: int32
        operationsSorter:
          type: string
          enum:
            - alpha
            - method
        showExtensions:
          type: boolean
        showCommonExtensions:
          type: boolean
        tagsSorter:
          type: string
          enum:
            - alpha
        validatorUrl:
          type: string
        supportedSubmitMethods:
          type: array
          items:
            type: string
        swaggerBaseUiUrl:
          type: string
    SecurityConfiguration:
      type: object
      properties:
        apiKey:
          type: string
          deprecated: true
        apiKeyVehicle:
          type: string
          deprecated: true
        apiKeyName:
          type: string
          deprecated: true
        clientId:
          type: string
        clientSecret:
          type: string
        realm:
          type: string
        appName:
          type: string
        scopeSeparator:
          type: string
        additionalQueryStringParams:
          type: object
          additionalProperties:
            type: object
        useBasicAuthenticationWithAccessCodeGrant:
          type: boolean
        enableCsrfSupport:
          type: boolean
